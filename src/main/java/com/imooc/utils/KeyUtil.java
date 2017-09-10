package com.imooc.utils;

import java.util.Random;

/**
 * Created by hasee on 2017/9/10.
 */
public class KeyUtil {

    /**
     * 生成唯一字符串用于设置主键
     * @return
     */
    public static String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
