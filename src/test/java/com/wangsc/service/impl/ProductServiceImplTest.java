package com.wangsc.service.impl;

import com.wangsc.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
/**
 * @author wangsc
 * @date 2019-9-13 15:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productService;

    @Test
    public void findById() {
        ProductInfo productInfo = productService.findById("123456");
        Assert.assertEquals("123456", productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> serviceUpAll = productService.findUpAll();
        Assert.assertNotEquals(0, serviceUpAll.size());
    }

    @Test
    public void findAll() {
        PageRequest pageable = PageRequest.of(1, 3);
        Page<ProductInfo> productInfos = productService.findAll(pageable);
        System.out.println(productInfos);
        Assert.assertNotEquals(0, productInfos);
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("654321");
        productInfo.setProductName("银耳莲子羹");
        productInfo.setProductPrice(new BigDecimal(22.5));
        productInfo.setProductStock(200);
        productInfo.setProductDescription("美容养颜又好喝");
        productInfo.setProductIcon("https://image.icon.com");
        productInfo.setProductStatus(1);
        productInfo.setCategoryType(2);

        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}