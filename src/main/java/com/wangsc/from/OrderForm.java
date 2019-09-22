package com.wangsc.from;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author wangsc
 * @version 1.0
 * @date 2019-9-21 21:20
 */
@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名不能为空")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号不能为空")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址不能为空")
    private String address;

    /**
     * 买家微信号openid
     */
    @NotEmpty(message = "微信号不能为空")
    private String openid;

    /**
     * 买家购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
