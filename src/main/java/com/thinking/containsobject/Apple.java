package com.thinking.containsobject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 李昭
 * @Date: 2020/6/7 9:23
 */
public class Apple {
    private static long counter;
    private static long id = counter++;

    public long id() {
        return id;
    }
}

class Orange {
}

class AppleAndOrangesWithoutGenerics {
    public static void main(String[] args) {
        List apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        apples.add(new Orange());
        for (int i = 0; i < apples.size(); i++) {
            //ClassCastException
//            ((Apple)apples.get(i)).id();
        }
        List<Apple> appleList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            appleList.add(new Apple());
        }

        for (int i = 0; i < appleList.size(); i++) {
            System.out.println(appleList.get(i).id());
        }
        for (Apple apple : appleList) {
            System.out.println(apple.id());
        }

    }
}