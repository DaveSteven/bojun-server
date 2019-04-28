package com.bojun.service.impl;

import com.bojun.common.ServerResponse;
import com.bojun.dao.ProductMapper;
import com.bojun.data.entity.Product;
import com.bojun.service.IProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("IProductService")
public class ProductImpl implements IProductService {

    @Resource
    private ProductMapper productMapper;

    public ServerResponse<String> addProduct(Product product) {
        int resultCount = productMapper.insert(product);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse<String> deleteProduct(Integer id) {
        int resultCount = productMapper.deleteByPrimaryKey(id);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse<String> modifyProduct(Product product) {
        int resultCount = productMapper.updateByPrimaryKeySelective(product);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse getProductList(Integer start, Integer limit) {
        PageHelper.startPage(start, limit);
        Page<Product> productList = productMapper.selectAll();
        PageInfo pageInfo = new PageInfo<>(productList);
        return ServerResponse.createBySuccess(pageInfo);
    }
}
