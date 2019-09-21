package com.wangsc.enums;

import lombok.Getter;

/**
 * @author wangsc
 * @date 2019-9-14 23:33
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10, "商品不存在"),

    PRODUCT_STOCK_ERROR(11, "商品库存不正确"),

    ORDER_STOCK_ERROR(12, "订单不存在"),

    ORDERDETAIL_STOCK_ERROR(13, "订单详情不存在"),

    ORDER_STATUS_ERROR(14, "订单状态不正确"),

    ORDER_UPDATE_ERROR(15, "订单更新失败"),

    ORDER_DETAIL_EMPTY(16, "订单详情为空"),

    ORDER_PAY_STATUS_ERROR(17, "订单支付状态不正常"),

    ORDER_UPDATE_FAIL(18, "订单支付失败"),
    ;
    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
