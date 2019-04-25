package com.bojun.service.impl;

import com.bojun.common.ServerResponse;
import com.bojun.dao.AdministratorMapper;
import com.bojun.data.entity.Administrator;
import com.bojun.service.IAdministratorService;
import com.bojun.util.MD5Util;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;

@Service("IAdministratorService")
public class AdministratorImpl implements IAdministratorService {

    @Resource
    private AdministratorMapper administratorMapper;

    public ServerResponse<String> addAdmin(Administrator admin) {
        ServerResponse validResponse = this.isExistAdmin(admin.getUsername());
        if (!validResponse.isSuccess()) {
            return validResponse;
        }

        String md5Password = MD5Util.MD5EncodeUtf8(admin.getPassword());
        admin.setPassword(md5Password);
        admin.setAccess("super_admin");

        int resultCount = administratorMapper.insert(admin);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("添加管理员失败");
        }

        return ServerResponse.createBySuccessMessage("添加管理员成功");
    }

    public ServerResponse<Administrator> login(String username, String password) {
        int resultCount = administratorMapper.isExistAdmin(username);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("用户不存在");
        }

        String md5Password = MD5Util.MD5EncodeUtf8(password);
        Administrator admin = administratorMapper.selectLogin(username, md5Password);
        if (null == admin) {
            return ServerResponse.createByErrorMessage("密码错误");
        }

        admin.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功", admin);
    }

//    public ServerResponse<Administrator> getUserInfo()

    private ServerResponse<String> isExistAdmin(String username) {
        int resultCount = administratorMapper.isExistAdmin(username);

        if (StringUtils.isNotBlank(username)) {
            if (resultCount > 0) {
                return ServerResponse.createByErrorMessage("用户已存在");
            }
        } else {
            return ServerResponse.createByErrorMessage("用户名不能为空");
        }

        return ServerResponse.createBySuccessMessage("校验成功");
    }
}
