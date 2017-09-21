package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.service.PayService;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hasee on 2017/9/21.
 */
@Service
public class PayServiceImpl implements PayService{

    @Autowired
    private BestPayServiceImpl bestPayService;

    public void create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        bestPayService.pay(payRequest);
    }
}
