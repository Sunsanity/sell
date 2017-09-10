package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by hasee on 2017/9/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    private final String OPENID = "666";

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("2");
        orderMaster.setBuyerName("孙晶文");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setBuyerPhone("13269907291");
        orderMaster.setBuyerAddress("齐齐哈尔");
        orderMaster.setOrderAmount(new BigDecimal(123));

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindByBuyerOpenId() throws Exception {
        PageRequest pageRequest = new PageRequest(0,1);

        Page<OrderMaster> result = orderMasterRepository.findByBuyerOpenid(OPENID,pageRequest);
        Assert.assertNotEquals(0,result.getTotalElements());
    }
}