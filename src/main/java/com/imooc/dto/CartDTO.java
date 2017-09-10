package com.imooc.dto;

import lombok.Data;

/**
 * Created by hasee on 2017/9/10.
 * 购物车DTO
 */
@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
