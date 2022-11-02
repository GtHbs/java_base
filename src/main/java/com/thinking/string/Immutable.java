package com.thinking.string;

import java.util.Random;

/**
 * @Author 李昭
 * @Date 2020/6/16 18/58
 */
public class Immutable {

    public static String upcase(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(upcase("howdy"));
    }
}

class WhitherStringBuilder {

    public String implicit(String[] fields) {
        String result = "";
        for (int i = 0; i < fields.length; i++) {
            result += fields[i];
        }
        return result;
    }

    public String explicit(String[] fields) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            builder.append(fields[i]);
        }
        return builder.toString();
    }
}

class UsingStringBuilder {
    public static Random random = new Random(47);

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            builder.append(random.nextInt(100));
            builder.append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        UsingStringBuilder builder = new UsingStringBuilder();
        System.out.println(builder);
    }

}