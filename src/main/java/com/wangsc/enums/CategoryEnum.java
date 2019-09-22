package com.wangsc.enums;

import lombok.Getter;

/**
 * @author wangsc
 * @version 1.0
 * @date 2019-9-22 15:30
 */
@Getter
public enum CategoryEnum {

    CATEGORY_NOT_EXIST(0, "商品类目不存在"),
    ;

    private Integer code;

    private String message;

    CategoryEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
