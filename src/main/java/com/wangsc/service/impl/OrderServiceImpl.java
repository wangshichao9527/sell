package com.wangsc.service.impl;

import com.wangsc.converter.OrderMasterConverterOrderDTO;
import com.wangsc.dataobject.OrderDetail;
import com.wangsc.dataobject.OrderMaster;
import com.wangsc.dataobject.ProductInfo;
import com.wangsc.dto.CartDTO;
import com.wangsc.dto.OrderDTO;
import com.wangsc.enums.OrderStatusEnum;
import com.wangsc.enums.PayStatusEnum;
import com.wangsc.enums.ResultEnum;
import com.wangsc.exception.SellException;
import com.wangsc.repository.OrderDetailRepository;
import com.wangsc.repository.OrderMasterRepository;
import com.wangsc.service.OrderService;
import com.wangsc.service.ProductInfoService;
import com.wangsc.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author wangsc
 * @Date 2019-9-14 23:25
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTo) {
        String orderId = KeyUtil.getUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        //根据入参id查询商品是否存在，不存在直接抛异常
        List<OrderDetail> orderDetailList = orderDTo.getOrderDetailList();
//        List<CartDTO> cartDTOList = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetailList) {

            ProductInfo productInfo = productInfoService.findById(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //存在则取数据库查询单价，计算总价
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
            //订单详情写入数据库
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);
            orderDetailRepository.save(orderDetail);
            //构造库存列表
//            CartDTO cartDTO = new CartDTO();
//            cartDTO.setProductId(orderDetail.getProductId());
//            cartDTO.setProductQuantity(orderDetail.getProductQuantity());
//            cartDTOList.add(cartDTO);
        }
        //写订单详情数据
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTo, orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        //减库存
        List<CartDTO> cartDTOList = orderDetailList.stream().map(e ->
            new CartDTO(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());
                productInfoService.deincreaseStock(cartDTOList);

        return orderDTo;
    }

    @Override
    public OrderDTO findOne(String orderId) {

        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();
        if (orderMaster == null) {
            throw new SellException(ResultEnum.ORDER_STOCK_ERROR);
        }
        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(orderId);
        if (orderMaster == null) {
            throw new SellException(ResultEnum.ORDERDETAIL_STOCK_ERROR);
        }
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setOrderDetailList(orderDetails);
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findByBuyerOpenid(buyerOpenid, pageable);
        List<OrderDTO> orderDTOList = OrderMasterConverterOrderDTO.convert(orderMasterPage.getContent());
        return new PageImpl<>(orderDTOList, pageable, orderMasterPage.getTotalElements());
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {

        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTo) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTo) {
        return null;
    }
}
