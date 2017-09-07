package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by hasee on 2017/9/6.
 * 测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = productCategoryRepository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void insertTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(3);
        productCategoryRepository.save(productCategory);
    }

    @Test
    public void updateTest(){
        ProductCategory productCategory = productCategoryRepository.findOne(2);
        productCategory.setCategoryType(888);
        productCategoryRepository.save(productCategory);
    }
}