package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.enums.PayStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.OrderService;
import com.imooc.service.PayService;
import com.imooc.utils.JsonUtil;
import com.imooc.utils.MathUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hasee on 2017/9/21.
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService{

    private static final String ORDER_NAME = "微信点餐订单";

    @Autowired
    private BestPayServiceImpl bestPayService;
    @Autowired
    private OrderService orderService;

    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信支付】发起支付，request={}", JsonUtil.toJson(payRequest));
        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【微信支付】发起支付，response={}",JsonUtil.toJson(payResponse));

        return payResponse;
    }

    /**
     * 接收微信支付成功后的异步通知
     * @param notifyData
     * @return
     */
    public PayResponse notify(String notifyData) {
        //需要注意的几个点
        //1.验证是否是微信官方发来的异步通知
        //2.验证订单是否是正确的订单状态
        //3.验证订单的支付金额和系统中的订单金额是否一致
        //4.验证下单人和支付人是否一致（根据业务）
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("【微信支付】异步通知，payResponse={}",JsonUtil.toJson(payResponse));

        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());
        //验证订单是否存在
        if (orderDTO == null){
            log.error("【微信支付】异步通知，订单不存在，orderId={}",payResponse.getOrderId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //验证金额是否一致
        if (!MathUtil.equals(payResponse.getOrderAmount(),orderDTO.getOrderAmount().doubleValue())){
            log.error("【微信支付】异步通知，订单金额不一致，orderId={},微信支付金额={},系统金额={}",payResponse.getOrderId(),payResponse.getOrderAmount(),orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.WECHAT_PAY_AMOUNT_ERROR);
        }

        //验证通过，修改订单状态
        orderService.paid(orderDTO);

        return payResponse;
    }

    /**
     * 微信退款
     * @param orderDTO
     * @return
     */
    public RefundResponse refund(OrderDTO orderDTO){
        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setOrderId(orderDTO.getOrderId());
        refundRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信退款】request={}",JsonUtil.toJson(refundRequest));

        RefundResponse refundResponse = bestPayService.refund(refundRequest);
        log.info("【微信退款】response={}",JsonUtil.toJson(refundResponse));

        return refundResponse;
    }
}
