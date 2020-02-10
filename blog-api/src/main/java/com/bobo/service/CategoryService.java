package com.bobo.service;

import java.util.List;

import com.bobo.entity.Category;
import com.bobo.vo.CategoryVO;

public interface CategoryService {

    List<Category> findAll();

    Category getCategoryById(Integer id);

    Integer saveCategory(Category category);

    Integer updateCategory(Category category);

    void deleteCategoryById(Integer id);

    List<CategoryVO> findAllDetail();

    CategoryVO getCategoryDetail(Integer categoryId);

}
