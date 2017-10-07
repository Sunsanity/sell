package com.imooc.enums;

import lombok.Getter;

/**
 * Created by hasee on 2017/9/10.
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{
    NEW(0,"新订单"),
    FINISHED(1,"已完成"),
    CANCEL(2,"已取消"),
    ;
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
