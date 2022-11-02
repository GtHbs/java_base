package com.thinking.operator.util;

/**
 * @author 李昭
 * @Date 7:39 2020/5/12
 * @Description:
 * @Modified By:
 */
public class Print {

    public static void print(Object... args) {
        for (Object o : args) {
            System.out.println(o);
        }
    }
}
