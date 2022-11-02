package com.thinking.array.arrays;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author 李昭
 * @Date 2020/6/21 13/16
 */
public class StringSorting {
    public static void main(String[] args) {
        String[] str = {
                "sh",
                "dhui",
                "duhi",
                "asah",
                "euo",
                "siojo",
                "fjijo"
        };
        System.out.println("Before sorting");
        System.out.println(Arrays.toString(str));
        Arrays.sort(str);
        System.out.println("After Sorting");
        System.out.println(Arrays.toString(str));
        Arrays.sort(str, Collections.reverseOrder());
        System.out.println("Reverse sort: " + Arrays.toString(str));
        Arrays.sort(str, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Case-insensitive sort: " + Arrays.toString(str));
    }
}
