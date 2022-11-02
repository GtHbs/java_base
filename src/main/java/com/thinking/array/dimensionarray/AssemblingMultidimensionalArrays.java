package com.thinking.array.dimensionarray;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author 李昭
 * @Date 2020/6/21 09/46
 */
public class AssemblingMultidimensionalArrays {
    public static void main(String[] args) {
        Integer[][] a;
        a = new Integer[3][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Integer[3];
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = i * j;
            }
        }
        System.out.println(Arrays.deepToString(a));
        int[][][] s = new int[2][3][4];
        System.out.println(Arrays.deepToString(s));
        double[][] doubles = initializeMultiDimensionalArray(2, 3);
        System.out.println(Arrays.deepToString(doubles));

    }

    public static double[][] initializeMultiDimensionalArray(int outer, int inner) {
        Random random = new Random(47);
        double[][] a = new double[outer][inner];
        for (int i = 0; i < outer; i++) {
            for (int j = 0; j < inner; j++) {
                a[i][j] = random.nextInt(Math.min(outer,inner));
            }
        }
        return a;
    }
}
