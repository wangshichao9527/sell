package com.wangsc.controller;

import com.wangsc.dataobject.ProductCategory;
import com.wangsc.dataobject.ProductInfo;
import com.wangsc.service.CategoryService;
import com.wangsc.service.ProductInfoService;
import com.wangsc.utils.ResultVOUtil;
import com.wangsc.vo.ProductInfoVo;
import com.wangsc.vo.ProductVo;
import com.wangsc.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangsc
 * @date 2019-9-13 15:25
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO List() {
        //1、查出所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        //2、查询类目
        //2.1、传统方法
        ArrayList<Integer> categoryTypeList = new ArrayList<>();
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }
        //2.2、精简方法(lambda表达式)
        List<Integer> cacategoryTypeList2 = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        //3拼装方法
        //3.1、首先查询商品类目列表
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //分析date数据是由 resultVO->ProductVo->productVoList->productVo
        ArrayList<ProductVo> productVoList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryType(productCategory.getCategoryType());
            productVo.setCategoryName(productCategory.getCategoryName());
            ArrayList<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                //上架商品类目编号与类目表编号对比
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    //将相同编号的productInfo数据拷贝到productInfoVo中
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }

        return ResultVOUtil.success(productVoList);
    }
}
