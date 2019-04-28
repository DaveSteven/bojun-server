package com.bojun.controller;

import com.bojun.common.ServerResponse;
import com.bojun.data.entity.Category;
import com.bojun.service.ICategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private ICategoryService iCategoryService;

    /**
     * 增加
     * @param category
     * @return
     */
    @PostMapping("/add")
    public ServerResponse<String> addProduct(Category category) {
        return iCategoryService.addCategory(category);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public ServerResponse<String> deleteProduct(Integer id) {
        return iCategoryService.deleteCategory(id);
    }

    /**
     * 修改
     * @param category
     * @return
     */
    @PostMapping("/modify")
    public ServerResponse<String> modifyProduct(Category category) {
        return iCategoryService.modifyCategory(category);
    }

    /**
     * 获取列表
     * @param
     * @param
     * @return
     */
    @PostMapping("/getList")
    public ServerResponse getProductList() {
        return iCategoryService.getCategoryList();
    }
}
