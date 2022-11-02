package com.thinking.generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author 李昭
 * @Date 2020/6/18 21/38
 */
public class Generators {
    public static <T> Collection<T> fill(Collection<T> collection, Generator<T> generator, int n) {
        for (int i = 0; i < n; i++) {
            collection.add(generator.next());
        }
        return collection;
    }


    public static void main(String[] args) {
        Collection<Coffee> fill = fill(new ArrayList<>(), new CoffeeGenerator(), 4);
        for (Coffee c : fill) {
            System.out.println(c);
        }
        Collection<Integer> integers = fill(new ArrayList<>(), new Fibonacci(), 12);
        for (Integer i : integers) {
            System.out.print(i + " ");
        }
    }
}

