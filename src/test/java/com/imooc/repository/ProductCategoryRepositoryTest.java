package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        ProductCategory productCategory = productCategoryRepository.findOne(2);
        System.out.println(productCategory.toString());
    }

    @Test
    public void insertTest(){
        ProductCategory productCategory = new ProductCategory("女生最爱",3);
        ProductCategory result = productCategoryRepository.save(productCategory);
        Assert.assertNotNull(result);
}

    @Test
    public void updateTest(){
        ProductCategory productCategory = productCategoryRepository.findOne(3);
        productCategory.setCategoryType(111);
        productCategoryRepository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeIn(){
        List<ProductCategory> list = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(1,2,3));
        Assert.assertNotEquals(0,list.size());
    }
}