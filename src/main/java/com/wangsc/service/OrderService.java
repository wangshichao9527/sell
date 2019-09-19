package com.wangsc.service;

import com.wangsc.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author wangsc
 * @Date 2019-9-14 23:15
 */
public interface OrderService {

    /**
     * 创建订单.
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询单个订单.
     */
    OrderDTO findOne(String orderId);

    /**
     * 查询订单列表.
     */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /** 取消订单. */
    OrderDTO cancel(OrderDTO orderDTo);

    /** 完结订单. */
    OrderDTO finish(OrderDTO orderDTo);

    /** 支付订单. */
    OrderDTO paid(OrderDTO orderDTo);

}
