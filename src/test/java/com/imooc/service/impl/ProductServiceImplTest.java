package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hasee on 2017/9/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void testFindUpAll() throws Exception {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void testFindOne() throws Exception {
        ProductInfo productInfo = productService.findOne("12312344");
        Assert.assertNotNull(productInfo);
    }

    @Test
    public void testFindAll() throws Exception {
        PageRequest pageRequest = new PageRequest(0,10);
        Page<ProductInfo> pageResult = productService.findAll(pageRequest);
        Assert.assertNotEquals(0,pageResult.getContent().size());
    }

    @Test
    public void testSave() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("12312344");
        productInfo.setCategoryType(3);
        productInfo.setProductDescription("很不错");
        productInfo.setProductIcon("http://123.com");
        productInfo.setProductName("icecream");
        productInfo.setProductPrice(new BigDecimal(10));
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        productInfo.setProductStock(1000);

        ProductInfo productInfo1 = productService.save(productInfo);
        Assert.assertNotNull(productInfo1);
    }
}