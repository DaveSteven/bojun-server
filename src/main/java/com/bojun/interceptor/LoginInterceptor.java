package com.bojun.interceptor;

import com.bojun.common.Const;
import com.bojun.exception.MyException;
import com.bojun.util.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        String token = request.getHeader(Const.ACCESS_TOKEN);
        if (null != token) {
            boolean result = JwtUtil.verify(token);
            if (!result) {
                throw new MyException();
            }
        } else {
            throw new MyException();
        }
        return true;
    }
}
