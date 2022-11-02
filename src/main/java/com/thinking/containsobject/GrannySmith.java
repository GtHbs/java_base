package com.thinking.containsobject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 李昭
 * @Date: 2020/6/7 9:30
 */
public class GrannySmith extends Apple {
}

class Gula extends Apple {
}

class Fuji extends Apple {
}

class Braeburn extends Apple {
}

class GenericsAndUpcasting {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new GrannySmith());
        apples.add(new Gula());
        apples.add(new Fuji());
        apples.add(new Braeburn());
        for (Apple apple : apples) {
            System.out.println(apple);
        }
    }
}
