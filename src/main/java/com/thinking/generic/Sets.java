package com.thinking.generic;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author 李昭
 * @Date 2020/6/19 20/32
 */
public class Sets {
    /**
     * 并集<br>
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> set = new HashSet<>(a);
        set.addAll(b);
        return set;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> set = new HashSet<>(a);
        set.retainAll(b);
        return set;
    }

    /**
     * 差集<br>
     */
    public static <T> Set<T> difference(Set<T> a, Set<T> b) {
        Set<T> set = new HashSet<>(a);
        set.removeAll(b);
        return set;
    }


    /**
     * 补集<br>
     */
    public static <T> Set<T> compliment(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }

}
