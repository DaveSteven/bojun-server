package com.bojun.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Banner {
    private Integer id;

    private String text;

    private String imgUrl;

    private String articleUrl;

    private String type;

    private Date createTime;

    private Date updateTime;
}