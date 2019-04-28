package com.bojun.service.impl;

import com.bojun.common.ServerResponse;
import com.bojun.dao.BannerMapper;
import com.bojun.data.entity.Banner;
import com.bojun.service.IBannerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("IBannerService")
public class BannerImpl implements IBannerService {

    @Resource
    private BannerMapper bannerMapper;

    public ServerResponse<String> addBanner(Banner banner) {
        int resultCount = bannerMapper.insert(banner);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse<String> deleteBanner(Integer id) {
        int resultCount = bannerMapper.deleteByPrimaryKey(id);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse<String> editBanner(Banner banner) {
        int resultCount = bannerMapper.updateByPrimaryKeySelective(banner);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse getBannerList(Integer start, Integer limit) {
        PageHelper.startPage(start, limit);
        Page<Banner> bannerList = bannerMapper.selectAll();
        PageInfo pageInfo = new PageInfo<>(bannerList);
        return ServerResponse.createBySuccess(pageInfo);
    }
}
