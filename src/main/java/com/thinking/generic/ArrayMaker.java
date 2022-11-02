package com.thinking.generic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 李昭
 * @Date 2020/6/20 16/32
 */
public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    T[] create(int size) {
        /**
         * 这一步必须进行强制转型,是因为T为泛化类型,在创建对象时并不知道其具体的类型,因此kind实际类型为Class
         * 而要在运行时返回一个具体的类型,因此必须进行类型强转
         */
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> maker = new ArrayMaker<>(String.class);
        String[] strings = maker.create(9);
        System.out.println(Arrays.toString(strings));
    }
}

class ListMaker<T> {
    List<T> create() {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        ListMaker<String> maker = new ListMaker<>();
        List<String> list = maker.create();
    }
}

class FilledListMaker<T> {
    List<T> create(T t, int n) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {
        FilledListMaker<String> maker = new FilledListMaker<>();
        List<String> list = maker.create("Hello", 4);
        System.out.println(list);
    }
}