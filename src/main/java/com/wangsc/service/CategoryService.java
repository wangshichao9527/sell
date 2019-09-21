package com.wangsc.service;

import com.wangsc.dataobject.ProductCategory;

import java.util.List;

/**
 * @author wangsc
 * @date 2019-9-13 15:25
 */
public interface CategoryService {

    ProductCategory findById(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
