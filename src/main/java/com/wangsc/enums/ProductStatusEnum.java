package com.wangsc.enums;

import lombok.Getter;

/**
 * @author wangsc
 * @date 2019-9-13 19:53
 */
@Getter
public enum ProductStatusEnum {

    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
