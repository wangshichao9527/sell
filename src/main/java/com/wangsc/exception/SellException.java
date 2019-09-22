package com.wangsc.exception;

import com.wangsc.enums.CategoryEnum;
import com.wangsc.enums.PayStatusEnum;
import com.wangsc.enums.ResultEnum;
import lombok.Getter;

/**
 * @author wangsc
 * @date 2019-9-14 23:35
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(PayStatusEnum payStatusEnum) {
        super(payStatusEnum.getMessage());
        this.code = payStatusEnum.getCode();
    }

    public SellException(CategoryEnum categoryEnum) {
        super(categoryEnum.getMessage());
        this.code = categoryEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
