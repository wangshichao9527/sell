package com.wangsc.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author wangsc
 * @date 2019-9-13 15:25
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /**
     * 名字.
     */
    private String productName;

    /**
     * 单价.
     */
    private BigDecimal productPrice;

    /**
     * 库存.
     */
    private Integer productStock;

    /**
     * 描述.
     */
    private String productDescription;

    /**
     * 小图.
     */
    private String productIcon;

    /**
     * 类目编号.
     */
    private Integer categoryType;

    /**
     * 状态，0正常1下架.
     */
    private Integer productStatus;
}
