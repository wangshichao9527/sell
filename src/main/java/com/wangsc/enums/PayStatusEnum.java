package com.wangsc.enums;

import lombok.Getter;

/**
 * @author wangsc
 * @date 2019-9-13 19:53
 */
@Getter
public enum PayStatusEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功");

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
