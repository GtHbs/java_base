package com.thinking.array.arrayandgeneric;

/**
 * @Author 李昭
 * @Date 2020/6/21 09/54
 */
public class ClassParameter<T> {
    public T[] f(T[] arg) {
        return arg;
    }
}

class MethodParameter {
    public static <T> T[] f(T[] arg) {
        return arg;
    }
}

class ParameterizedArrayType {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
        Integer[] integers = new ClassParameter<Integer>().f(ints);
        Double[] f = new ClassParameter<Double>().f(doubles);
        integers = MethodParameter.f(ints);
        f = MethodParameter.f(doubles);
    }
}