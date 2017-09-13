package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * Created by hasee on 2017/9/13.
 */
public interface BuyerService {

    OrderDTO findOneOrder(String openid, String orderId);

    OrderDTO cancelOrder(String openid,String orderId);
}
