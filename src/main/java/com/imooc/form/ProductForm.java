package com.imooc.form;

import com.imooc.enums.ProductStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by hasee on 2017/10/11.
 */
@Data
public class ProductForm {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer categoryType;
}
