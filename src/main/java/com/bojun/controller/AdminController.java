package com.bojun.controller;

import com.bojun.common.ServerResponse;
import com.bojun.data.entity.Administrator;
import com.bojun.service.IAdministratorService;
import com.bojun.util.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private IAdministratorService iAdminService;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public ServerResponse login(String username, String password) {
        ServerResponse<Administrator> response = iAdminService.login(username, password);
        if (response.isSuccess()) {
            Administrator admin = response.getData();
            String token = JwtUtil.sign(username, admin.getId());
            if (null != token) {
                Map<String, Object> map = new HashMap<>(2);
                map.put("token", token);
                return ServerResponse.createBySuccess("登录成功", map);
            }
        }
        return response;
    }

    /**
     * 添加用户
     * @param admin
     * @return
     */
    @PostMapping("/add")
    public ServerResponse addAdmin(Administrator admin) {
        return iAdminService.addAdmin(admin);
    }

    /**
     * 获取用户信息
     * @return
     */
    @PostMapping("/getInfo")
    public ServerResponse getUserInfo() {
        return iAdminService.getUserInfo();
    }
}
