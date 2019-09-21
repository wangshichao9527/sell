package com.wangsc.dto;

import lombok.Data;

/**
 * @author wangsc
 * @date 2019-9-15 22:42
 */
@Data
public class CartDTO {

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
