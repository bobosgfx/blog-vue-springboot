package com.bobo.service.impl;

import java.util.List;

import com.bobo.entity.Category;
import com.bobo.repository.CategoryRepository;
import com.bobo.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bobo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.getOne(id);
    }

    @Override
    @Transactional
    public Integer saveCategory(Category category) {

        return categoryRepository.save(category).getId();
    }

    @Override
    @Transactional
    public Integer updateCategory(Category category) {
        Category oldCategory = categoryRepository.getOne(category.getId());

        oldCategory.setCategoryname(category.getCategoryname());
        oldCategory.setAvatar(category.getAvatar());
        oldCategory.setDescription(category.getDescription());

        return oldCategory.getId();
    }

    @Override
    @Transactional
    public void deleteCategoryById(Integer id) {
        categoryRepository.delete(id);
    }

    @Override
    public List<CategoryVO> findAllDetail() {
        return categoryRepository.findAllDetail();
    }

    @Override
    public CategoryVO getCategoryDetail(Integer categoryId) {
        return categoryRepository.getCategoryDetail(categoryId);
    }

}
