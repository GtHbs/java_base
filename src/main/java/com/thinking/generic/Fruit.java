package com.thinking.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 李昭
 * @Date 2020/6/20 20/35
 */
public class Fruit {
}

class Apple extends Fruit {

}

class Jonathan extends Apple {

}

class Orange extends Fruit {

}

class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();
        try {
            fruits[0] = new Fruit();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            fruits[0] = new Orange();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


class GenericAndCovariance {
    public static void main(String[] args) {
        /**
         * 使用通配符的泛型边界,任何对象都不能插入
         */
        List<? extends Fruit> list = new ArrayList<Apple>();
//        list.add(new Apple());
//        list.add(new Orange());
//        list.add(new Object());

    }
}

class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> list = Arrays.asList(new Apple());
        Apple apple = (Apple) list.get(0);
        System.out.println(apple);
        boolean contains = list.contains(new Apple());
        System.out.println(contains);
        int i = list.indexOf(new Apple());
        System.out.println(i);
    }
}