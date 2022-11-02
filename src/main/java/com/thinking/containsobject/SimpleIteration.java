package com.thinking.containsobject;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author: 李昭
 * @Date: 2020/6/8 7:45
 */
public class SimpleIteration {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }
        iterator = integers.iterator();
        for (int i = 0; i < integers.size(); i++) {
            iterator.next();
            iterator.remove();
        }

    }
}
