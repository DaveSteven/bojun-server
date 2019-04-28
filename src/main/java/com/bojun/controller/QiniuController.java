package com.bojun.controller;

import com.bojun.common.ServerResponse;
import com.bojun.service.IQiniuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/qiniu")
public class QiniuController {

    @Resource
    private IQiniuService iQiniuService;

    @GetMapping("/getUpToken")
    public ServerResponse<String> getUpToken() {
        return iQiniuService.getUpToken();
    }
}
