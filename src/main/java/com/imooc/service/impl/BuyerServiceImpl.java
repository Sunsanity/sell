package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.BuyerService;
import com.imooc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hasee on 2017/9/13.
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService{

    @Autowired
    private OrderService orderService;

    /**
     * 根据openid和orderid查询一个订单
     * @param openid
     * @param orderId
     * @return
     */
    public OrderDTO findOneOrder(String openid,String orderId){
        return checkOwner(openid,orderId);
    }

    /**
     * 根据openid和orderid取消订单
     * @param openid
     * @param orderId
     * @return
     */
    public OrderDTO cancelOrder(String openid,String orderId){
        OrderDTO orderDTO = checkOwner(openid,orderId);
        if (orderDTO == null){
            log.error("【取消订单】订单不存在，无法取消，orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    /**
     * 检查订单是否属于当前用户
     * @param openid
     * @param orderId
     * @return
     */
    private OrderDTO checkOwner(String openid,String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null){
            return null;
        }
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询订单】订单不属于当前用户，openid={},orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
