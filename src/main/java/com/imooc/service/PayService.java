package com.imooc.service;

import com.imooc.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;

/**
 * Created by hasee on 2017/9/21.
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);
}
