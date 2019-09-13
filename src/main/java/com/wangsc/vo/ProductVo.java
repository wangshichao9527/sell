package com.wangsc.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wangsc.vo.ProductInfoVo;
import lombok.Data;

import java.util.List;

@Data
public class ProductVo {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;
}
