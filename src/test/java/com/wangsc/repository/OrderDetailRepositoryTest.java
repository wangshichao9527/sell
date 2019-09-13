package com.wangsc.repository;

import com.wangsc.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author wangsc
 * @Date 2019-9-13 22:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1");
        orderDetail.setOrderId("1");
        orderDetail.setProductIcon("image.icon.com");
        orderDetail.setProductId("1");
        orderDetail.setProductName("皮蛋瘦肉粥");
        orderDetail.setProductPrice(new BigDecimal(12.5));
        orderDetail.setProductQuantity(100);

        OrderDetail detail = repository.save(orderDetail);
        Assert.assertNotNull(detail);

    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> detailList = repository.findByOrderId("1");
        Assert.assertNotEquals(0, detailList.size());
    }
}