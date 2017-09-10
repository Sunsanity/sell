package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hasee on 2017/9/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void testFindOne() throws Exception {
        ProductCategory productCategory = categoryService.findOne(5);
        Assert.assertEquals(new Integer(3),productCategory.getCategoryType());
    }

    @Test
    public void testFindAll() throws Exception {
        List<ProductCategory> list = categoryService.findAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void testSave() throws Exception {
        ProductCategory productCategory = new ProductCategory("女生最喜爱",11);
        ProductCategory productCategory1 = categoryService.save(productCategory);
        Assert.assertNotNull(productCategory1);
    }

    @Test
    public void testFindByCategoryTypeIn() throws Exception {
        List<Integer> list = Arrays.asList(1,2,3,5);
        Assert.assertNotEquals(0,list.size());
    }
}