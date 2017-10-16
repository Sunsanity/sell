package com.imooc.exception;

import com.imooc.enums.ResultEnum;
import lombok.Getter;

/**
 * Created by hasee on 2017/9/10.
 */
@Getter
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
