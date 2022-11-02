package com.thinking.innerstudycollection.fillcollection;

import com.thinking.array.arrayandgeneric.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Author 李昭
 * @Date 2020/6/22 22/10
 */
public class CollectionDataGeneration {
    public static void main(String[] args) {
        System.out.println(new ArrayList<>(CollectionData.list(new RandomGenerator.Integer(), 10)));
        System.out.println(new HashSet<>(new CollectionData<>(new RandomGenerator.Integer(), 10)));
    }
}
