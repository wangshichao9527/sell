package com.wangsc.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 类名
 *
 */
@Entity
@Data
public class ProductCategory {

    /*** 类目Id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /*** 类目名*/
    private String categoryName;

    /*** 类目编号*/
    private Integer categoryType;



}
