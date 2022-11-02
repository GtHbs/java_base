package com.thinking.enumeration.randomaccess;

import java.util.Random;

/**
 * @Author 李昭
 * @Date 2020/7/14 07/18
 */
public class Enums {

    private static Random random = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> c) {
        return random(c.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[random.nextInt(values.length)];
    }

}
