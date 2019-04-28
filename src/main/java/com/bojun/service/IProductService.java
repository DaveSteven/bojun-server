package com.bojun.service;

import com.bojun.common.ServerResponse;
import com.bojun.data.entity.Product;

public interface IProductService {
    ServerResponse<String> addProduct(Product product);
    ServerResponse<String> deleteProduct(Integer id);
    ServerResponse<String> modifyProduct(Product product);
    ServerResponse getProductList(Integer start, Integer limit);
}
