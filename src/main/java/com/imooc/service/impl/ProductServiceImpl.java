package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.repository.ProductInfoRepository;
import com.imooc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hasee on 2017/9/9.
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductInfoRepository productInfoRepository;

    public List<ProductInfo> findUpAll(){
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    public ProductInfo findOne(String productId){
        return productInfoRepository.findOne(productId);
    }

    public Page<ProductInfo> findAll(Pageable pageable){
        return productInfoRepository.findAll(pageable);
    }

    public ProductInfo save(ProductInfo productInfo){
        return productInfoRepository.save(productInfo);
    }
}
