package com.bojun.controller;

import com.bojun.common.ServerResponse;
import com.bojun.data.entity.Banner;
import com.bojun.service.IBannerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/banner")
public class BannerController {

    @Resource
    private IBannerService iBannerService;

    @PostMapping("/add")
    public ServerResponse<String> addBanner(Banner banner) {
       return iBannerService.addBanner(banner);
    }

    /**
     * 获取banner列表
     * @param start
     * @param limit
     * @return
     */
    @PostMapping("/list")
    public ServerResponse getBannerList(@RequestParam(value = "start", defaultValue = "0") Integer start, @RequestParam(value = "limit", defaultValue = "9") Integer limit) {
        return iBannerService.getBannerList(start, limit);
    }
}
