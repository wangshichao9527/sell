package com.wangsc.enums;

import lombok.Getter;

/**
 * @author wangsc
 * @date 2019-9-13 19:47
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    CANCEL(2, "已取消"),
    FINISHED(3, "完结");

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
