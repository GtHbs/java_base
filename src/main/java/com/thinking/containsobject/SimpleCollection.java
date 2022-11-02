package com.thinking.containsobject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author: 李昭
 * @Date: 2020/6/7 9:40
 */
public class SimpleCollection {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            collection.add(i);
        }
        for (Integer i : collection) {
            System.out.print(i + ","+'\t');
        }
        collection = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            collection.add((int) (Math.random() * i));
        }
        collection.stream().forEach(System.out::print);
    }
}
