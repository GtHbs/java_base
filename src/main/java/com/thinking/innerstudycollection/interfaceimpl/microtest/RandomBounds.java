package com.thinking.innerstudycollection.interfaceimpl.microtest;

/**
 * @Author 李昭
 * @Date 2020/6/30 07/45
 */
public class RandomBounds {

    public static void main(String[] args) {
        while (Math.random() != 0.0);
        System.out.println("produced 0.0!");
        while (Math.random() != 1.0);
        System.out.println("produced 1.0!");
    }
}
