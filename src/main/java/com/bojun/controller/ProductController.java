package com.bojun.controller;

import com.bojun.common.ServerResponse;
import com.bojun.data.entity.Product;
import com.bojun.service.IProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private IProductService iProductService;

    /**
     * 增加
     * @param product
     * @return
     */
    @PostMapping("/add")
    public ServerResponse<String> addProduct(Product product) {
        return iProductService.addProduct(product);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public ServerResponse<String> deleteProduct(Integer id) {
        return iProductService.deleteProduct(id);
    }

    /**
     * 修改
     * @param product
     * @return
     */
    @PostMapping("/modify")
    public ServerResponse<String> modifyProduct(Product product) {
        return iProductService.modifyProduct(product);
    }

    /**
     * 获取列表
     * @param start
     * @param limit
     * @return
     */
    @PostMapping("/getList")
    public ServerResponse getProductList(Integer start, Integer limit) {
        return iProductService.getProductList(start, limit);
    }
}
