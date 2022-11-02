package com.thinking.array.arrays;

import java.util.Arrays;

/**
 * @Author 李昭
 * @Date 2020/6/21 12/10
 */
public class ComparingArrays {
    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[7];
        Arrays.fill(i, 47);
        Arrays.fill(j, 99);
        System.out.println(Arrays.equals(i,j));
    }
}
