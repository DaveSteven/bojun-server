package com.bojun.service;

import com.bojun.common.ServerResponse;
import com.bojun.data.entity.Administrator;

public interface IAdministratorService {
    ServerResponse<String> addAdmin(Administrator admin);

    ServerResponse<Administrator> login(String username, String password);

    ServerResponse<Administrator> getUserInfo();
}