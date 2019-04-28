package com.bojun.service.impl;

import com.bojun.common.ServerResponse;
import com.bojun.dao.CategoryMapper;
import com.bojun.data.entity.Category;
import com.bojun.service.ICategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ICategoryService")
public class CategoryImpl implements ICategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    public ServerResponse<String> addCategory(Category category) {
        if (StringUtils.isBlank(category.getName())) {
            return ServerResponse.createByErrorMessage("分类名称不能为空");
        }
        int resultCount = categoryMapper.insert(category);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("添加成功");
        }
        return ServerResponse.createByError();
    }

    public ServerResponse<String> deleteCategory(Integer id) {
        int resultCount = categoryMapper.deleteByPrimaryKey(id);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByError();
    }

    public ServerResponse<String> modifyCategory(Category category) {
        int resultCount = categoryMapper.updateByPrimaryKeySelective(category);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createByError();
    }

    public ServerResponse getCategoryList() {
        List<Category> categoryList = categoryMapper.selectAll();
        return ServerResponse.createBySuccess(categoryList);
    }
}
