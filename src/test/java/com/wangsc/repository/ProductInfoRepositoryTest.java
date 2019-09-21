package com.wangsc.repository;

import com.wangsc.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wangsc
 * @date 2019-9-13 15:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋瘦肉粥");
        productInfo.setProductPrice(new BigDecimal(15.7));
        productInfo.setProductStock(500);
        productInfo.setProductDescription("营养又好喝");
        productInfo.setProductIcon("https://image.icon.com");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {

        List<ProductInfo> productStatus = repository.findByProductStatus(0);
        Assert.assertNotEquals(0, productStatus.size());
    }
}