package com.bojun.interceptor;

import com.bojun.annotation.LoginRequired;
import com.bojun.exception.MyException;
import com.bojun.util.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        Method method = ((HandlerMethod) handler).getMethod();
        boolean needLogin = method.isAnnotationPresent(LoginRequired.class);
        if (needLogin) {
            String token = request.getHeader("accessToken");
            if (null != token) {
                boolean result = JwtUtil.verify(token);
                if (!result) {
                    throw new MyException();
                }
            }
        }
        return true;
    }
}
