package com.wangsc.service.impl;

import com.wangsc.dataobject.ProductCategory;
import com.wangsc.repository.ProductCategoryRepository;
import com.wangsc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author wangsc
 * @date 2019-9-13 15:25
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findById(Integer categoryId) {
        Optional<ProductCategory> category = repository.findById(categoryId);
        ProductCategory productCategory = category.get();
        return productCategory;
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
