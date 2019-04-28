package com.bojun.service.impl;

import com.bojun.common.ServerResponse;
import com.bojun.service.IQiniuService;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Service;

@Service("IQiniuService")
public class QiniuImpl implements IQiniuService {

    public ServerResponse getUpToken() {
        // 空间密钥
        String ACCESS_KEY = "bAp4aQFzDzrH3hzpbZ_ySsiLjlZ8z2lc14PJBN3E";
        String SECRET_KEY = "QMvUW5lMSlbB0xvs4rLHZqg6PJtG3kGfdaw2ywBP";
        // 空间名
        String bucketName = "bojun-images";
        // 密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        // 简单上传，使用默认策略，只需要设置上传的空间名就可以了
        String token = auth.uploadToken(bucketName);
        return ServerResponse.createBySuccess(token);
    }
}
