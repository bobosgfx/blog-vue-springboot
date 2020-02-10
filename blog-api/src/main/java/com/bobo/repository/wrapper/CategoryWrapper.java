package com.bobo.repository.wrapper;

import java.util.List;

import com.bobo.vo.CategoryVO;

public interface CategoryWrapper {

    List<CategoryVO> findAllDetail();

    CategoryVO getCategoryDetail(Integer categoryId);
}
