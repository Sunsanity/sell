package com.imooc.VO;

import lombok.Data;

/**
 * Created by hasee on 2017/9/9.
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
