package com.bojun.service;

import com.bojun.common.ServerResponse;
import com.bojun.data.entity.Banner;


public interface IBannerService  {
    ServerResponse<String> addBanner(Banner banner);
    ServerResponse<String> deleteBanner(Integer id);
    ServerResponse<String> editBanner(Banner banner);
    ServerResponse getBannerList(Integer start, Integer limit);
}
