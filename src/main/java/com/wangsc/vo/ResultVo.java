package com.wangsc.vo;

import lombok.Data;

@Data
public class ResultVo<T> {

    /**
     * 错误码
     */
    private int code;

    /**
     * 错误码
     */
    private String msg;

    /**
     * 返回的具体内容
     */
    private T data;
}
