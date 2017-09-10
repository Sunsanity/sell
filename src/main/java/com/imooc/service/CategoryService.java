package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by hasee on 2017/9/9.
 * 类目service
 */
public interface CategoryService {

    public ProductCategory findOne(Integer categoryId);

    public List<ProductCategory> findAll();

    public ProductCategory save(ProductCategory productCategory);

    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
