package com.bojun.service;

import com.bojun.common.ServerResponse;
import com.bojun.data.entity.Category;

public interface ICategoryService {
    ServerResponse<String> addCategory(Category category);
    ServerResponse<String> deleteCategory(Integer id);
    ServerResponse<String> modifyCategory(Category category);
    ServerResponse getCategoryList();
}
