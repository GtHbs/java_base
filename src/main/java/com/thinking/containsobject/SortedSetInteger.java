package com.thinking.containsobject;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author: 李昭
 * @Date: 2020/6/9 19:46
 */
public class SortedSetInteger {
    public static void main(String[] args) {
        Random random = new Random(47);
        SortedSet<Integer> intset = new TreeSet<>();
        for (int i = 0; i < 10000; i++) {
            intset.add(random.nextInt(30));
        }
        System.out.println(intset);

    }
}
