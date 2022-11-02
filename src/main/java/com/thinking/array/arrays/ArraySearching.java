package com.thinking.array.arrays;

import com.thinking.array.arrayandgeneric.RandomGenerator;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author 李昭
 * @Date 2020/6/21 13/21
 */
public class ArraySearching {
    public static void main(String[] args) {
        Integer[] integers = new Integer[20];
        Random random = new Random(47);
        for (int i = 0; i < integers.length; i++) {
            integers[i] = random.nextInt(1000);
        }
        RandomGenerator.Integer integer = new RandomGenerator.Integer();
        Arrays.sort(integers);
        System.out.println("Sorted com.thinking.array: " + Arrays.toString(integers));
        while (true) {
            Integer next = integer.next();
            int location = Arrays.binarySearch(integers, next);
            System.out.println("Location of " + next + " is " + location + ", a[" + location + " ] = " + integers[location]);
            break;
        }
    }
}
