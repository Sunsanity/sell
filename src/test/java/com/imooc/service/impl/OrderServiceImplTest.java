package com.imooc.service.impl;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hasee on 2017/9/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String openid = "520";

    @Test
    public void testCreateOrder() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("张微");
        orderDTO.setBuyerAddress("哈尔滨");
        orderDTO.setBuyerOpenid(openid);
        orderDTO.setBuyerPhone("13269907291");

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123123");
        orderDetail.setProductQuantity(1);
        orderDetailList.add(orderDetail);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("12312344");
        orderDetail2.setProductQuantity(2);
        orderDetailList.add(orderDetail2);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.createOrder(orderDTO);
        log.info("创建订单result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindOne() throws Exception {

    }

    @Test
    public void testFindList() throws Exception {

    }

    @Test
    public void testPaid() throws Exception {

    }

    @Test
    public void testFinish() throws Exception {

    }

    @Test
    public void testCancel() throws Exception {

    }

    @Test
    public void testFindList1() throws Exception {

    }
}