package com.thinking.array.arrayandgeneric;

import com.thinking.generic.Generator;

import java.util.Random;

/**
 * @Author 李昭
 * @Date 2020/6/21 10/55
 */
public class RandomGenerator {
    private static Random random = new Random(47);
    public static class Boolean implements Generator<java.lang.Boolean> {

        @Override
        public java.lang.Boolean next() {
            return random.nextBoolean();
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {

        @Override
        public java.lang.Byte next() {
            return (byte)random.nextInt();
        }
    }

    public static class Integer implements Generator<java.lang.Integer> {

        private int mod = 10000;

        @Override
        public java.lang.Integer next() {
            return random.nextInt(mod);
        }
    }
}
