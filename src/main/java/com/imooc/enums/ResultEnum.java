package com.imooc.enums;

import lombok.Getter;

/**
 * Created by hasee on 2017/9/10.
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10,"商品不存在")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
