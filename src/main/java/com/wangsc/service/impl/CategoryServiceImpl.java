package com.wangsc.service.impl;

import com.wangsc.dataobject.ProductCategory;
import com.wangsc.enums.CategoryEnum;
import com.wangsc.exception.SellException;
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
        Optional<ProductCategory> categoryOptional = repository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            throw new SellException(CategoryEnum.CATEGORY_NOT_EXIST);
        } else {
            return categoryOptional.get();
        }
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
