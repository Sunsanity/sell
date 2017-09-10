package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by hasee on 2017/9/9.
 */
public interface ProductService {

    public List<ProductInfo> findUpAll();

    public ProductInfo findOne(String productId);

    public Page<ProductInfo> findAll(Pageable pageable);

    public ProductInfo save(ProductInfo productInfo);
}
