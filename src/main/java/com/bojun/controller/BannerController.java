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

    /**
     * 添加
     * @param banner banner实体
     * @return ServerResponse
     */
    @PostMapping("/add")
    public ServerResponse<String> addBanner(Banner banner) {
       return iBannerService.addBanner(banner);
    }



    /**
     * 获取banner列表
     * @param start 页码
     * @param limit 显示条数
     * @return ServerResponse
     */
    @PostMapping("/getList")
    public ServerResponse getBannerList(@RequestParam(value = "start", defaultValue = "0") Integer start, @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        return iBannerService.getBannerList(start, limit);
    }
}
