package com.wangsc.utils;

import java.util.Random;

/**
 * @Author wangsc
 * @Date 2019-9-15 11:21
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式：时间+随机数
     */
    public static synchronized String getUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
