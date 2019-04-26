package com.bojun.common;

public class Const {

    public static final String CURRENT_USER = "CURRENT_USER";
    public static final String EMAIL = "email";
    public static final String USRENAME = "username";
    public static final String ACCESS_TOKEN = "AccessToken";

    public interface Role {
        int ROLE_CUSTOMER = 0; // 普通用户
        int ROLE_ADMIN = 1; // 管理员
    }
}
