package com.bojun.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;

    private String name;

    private Integer categoryId;

    private String detail;

    private Date createTime;

    private Date updateTime;
}