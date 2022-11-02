package com.thinking.enumeration.values;

/**
 * @Author 李昭
 * @Date 2020/7/13 08/06
 */
public class NonEnum {
    public static void main(String[] args) {
        Class<Integer> zClass = Integer.class;
        for (Object e : zClass.getEnumConstants()) {
            System.out.println(e);
        }
    }
}
