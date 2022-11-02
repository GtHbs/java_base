package com.thinking.containsobject;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @author: 李昭
 * @Date: 2020/6/8 7:51
 */
public class ListIteration {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        ListIterator<Integer> iterator = integers.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + "," + iterator.nextIndex() + "," + iterator.previousIndex());
        }
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}
