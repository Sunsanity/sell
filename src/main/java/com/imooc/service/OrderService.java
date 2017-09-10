package com.imooc.service;

import com.imooc.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * Created by hasee on 2017/9/10.
 */
public interface OrderService {

    /**创建订单*/
    OrderDTO createOrder(OrderDTO orderDTO);

    /**根据openid查询单个订单*/
    OrderDTO findOne(String openId);

    /**根据openid分页查询订单列表*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**支付订单*/
    OrderDTO paid(OrderDTO orderDTO);

    /**完结订单*/
    OrderDTO finish(OrderDTO orderDTO);

    /**取消订单*/
    OrderDTO cancel(OrderDTO orderDTO);

    /**分页查询所有订单*/
    Page<OrderDTO> findList(Pageable pageable);
}
