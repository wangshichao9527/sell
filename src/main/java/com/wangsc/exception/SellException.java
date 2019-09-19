package com.wangsc.exception;

import com.wangsc.enums.ResultEnum;

/**
 * @Author wangsc
 * @Date 2019-9-14 23:35
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
