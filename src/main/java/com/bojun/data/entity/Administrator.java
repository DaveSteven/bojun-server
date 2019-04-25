package com.bojun.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administrator {
    private Integer id;

    private String username;

    private String password;

    private String uuid;

    private String avatar;

    private String name;

    private String access;

    private Date createTime;

    private Date updateTime;
}