package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * 推送消息
 * Created by hasee on 2017/10/16.
 */
public interface PushMessageService {

    void orderStatus(OrderDTO orderDTO);
}
