package com.thinking.generic;

import java.util.Arrays;
import java.util.List;

/**
 * @Author 李昭
 * @Date 2020/6/20 21/34
 */
public class GenericReading {
    /**
     * 使用精确的类型
     */
    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruits = Arrays.asList(new Fruit());

    static void f1() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruits);
        //向上转型不需要强转
        f = readExact(apples);
        System.out.println(f);
    }

    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static void f2() {
        Reader<Fruit> reader = new Reader<>();
        Fruit fruit = reader.readExact(fruits);
//        reader.readExact(apples);
    }

    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        CovariantReader<Fruit> reader = new CovariantReader<>();
        Fruit fruit = reader.readCovariant(fruits);
        System.out.println(fruit);
        Fruit covariant = reader.readCovariant(apples);
        System.out.println(covariant);
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }
}
