package com.bojun.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Integer id;

    private String name;

    private Date createTime;

    private Date updateTime;
}