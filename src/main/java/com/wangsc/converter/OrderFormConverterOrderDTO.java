package com.wangsc.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wangsc.dataobject.OrderDetail;
import com.wangsc.dto.OrderDTO;
import com.wangsc.enums.ResultEnum;
import com.wangsc.exception.SellException;
import com.wangsc.from.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangsc
 * @version 1.0
 * @date 2019-9-21 21:46
 */
@Slf4j
public class OrderFormConverterOrderDTO {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        ArrayList<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误，String={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
