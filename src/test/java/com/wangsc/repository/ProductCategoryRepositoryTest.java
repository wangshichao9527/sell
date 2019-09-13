package com.wangsc.repository;

import com.wangsc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void test1() {
        Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(1);
        System.out.println(productCategoryOptional);
    }

    @Test
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("飙升榜");
        productCategory.setCategoryType(3);
        ProductCategory category = productCategoryRepository.save(productCategory);
        System.out.println("category:{}," + category);
    }

    @Test
    public void updateTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("流行榜");
        productCategory.setCategoryType(3);
        ProductCategory category = productCategoryRepository.save(productCategory);
//        System.out.println("category:{}," + category);
        Assert.assertNotNull(category);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> asList = Arrays.asList(1, 2, 6);
        List<ProductCategory> categoryTypeInTest = productCategoryRepository.findByCategoryTypeIn(asList);
        Assert.assertNotEquals(0, categoryTypeInTest.size());
    }
}