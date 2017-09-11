package com.imooc.dto;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dataobject.ProductInfo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by hasee on 2017/9/10.
 */
@Data
public class OrderDTO {

    //订单号
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信Openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus;

    /** 订单项列表   */
    private List<OrderDetail> orderDetailList;
}
