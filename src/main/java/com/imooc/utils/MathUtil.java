package com.imooc.utils;

/**
 * Created by hasee on 2017/10/6.
 */
public class MathUtil {

    public static final Double MONEY_RANGE = 0.01;

    public static Boolean equals(Double d1,Double d2){
        Double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE){
            return true;
        }
        return false;
    }
}
