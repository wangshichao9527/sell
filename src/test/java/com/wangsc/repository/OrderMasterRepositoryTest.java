package com.wangsc.repository;

import com.wangsc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author wangsc
 * @Date 2019-9-13 20:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("3");
        orderMaster.setBuyerName("雷震子");
        orderMaster.setBuyerPhone("13212341234");
        orderMaster.setBuyerAddress("闵行区");
        orderMaster.setBuyerOpenid("10010");
        orderMaster.setOrderAmount(new BigDecimal(3.7));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = PageRequest.of(1,3);
        Page<OrderMaster> result = repository.findByBuyerOpenid("10010", pageRequest);
        //可以用result.getContent().size()来验证当前page页是否有数据
        Assert.assertNotEquals(0, result.getContent().size());
        System.out.println(result);
    }
}