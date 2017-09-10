package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hasee on 2017/9/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("2");
        orderDetail.setOrderId("111");
        orderDetail.setProductId("123");
        orderDetail.setProductName("大米粥");
        orderDetail.setProductIcon("www.baidu.com");
        orderDetail.setProductPrice(new BigDecimal(100));
        orderDetail.setProductQuantity(200);

        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindByOrderId() throws Exception {
        List<OrderDetail> resultList = orderDetailRepository.findByOrderId("111");
        Assert.assertNotEquals(0,resultList.size());
    }
}