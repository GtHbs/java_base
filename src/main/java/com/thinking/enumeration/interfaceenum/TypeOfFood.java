package com.thinking.enumeration.interfaceenum;

/**
 * @Author 李昭
 * @Date 2020/7/14 07/31
 */
public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Food.Appetizer.SALAD;
        food = Food.MainCourse.LASAGNE;
        food = Food.Dessert.GELATO;
        food = Food.Coffee.CAPPUCCINO;

    }
}
