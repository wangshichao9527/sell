package com.wangsc.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wangsc.dataobject.OrderDetail;
import com.wangsc.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author wangsc
 * @date 2019-9-14 23:12
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)    此方法已过时
//@JsonInclude(JsonInclude.Include.NON_NULL)    已在yml中配置全局
public class OrderDTO {

    /**
     * 买家名字.
     */
    private String orderId;

    /**
     * 买家名字.
     */
    private String buyerName;

    /**
     * 买家手机号码.
     */
    private String buyerPhone;

    /**
     * 买家地址.
     */
    private String buyerAddress;

    /**
     * 买家微信Openid.
     */
    private String buyerOpenid;

    /**
     * 订单总金额.
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态，默认为0新下单.
     */
    private Integer orderStatus;

    /**
     * 支付状态，默认为0未支付.
     */
    private Integer payStatus;

    /**
     * 创建时间.
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**
     * 更新时间.
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    /**
     * 订单详情列表.
     */
    private List<OrderDetail> orderDetailList;
}
