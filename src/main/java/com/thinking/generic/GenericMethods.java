package com.thinking.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 李昭
 * @Date 2020/6/18 21/23
 */
public class GenericMethods {
    public <T> void f(T t) {
        System.out.println(t.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods methods = new GenericMethods();
        methods.f(" ");
        methods.f(1);
        methods.f(1.0);
        methods.f(1.0f);
        methods.f('c');
        methods.f(methods);
    }
}

class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<>();
    }
}

class LimitOfInference {
    static void f(Map<Integer, List<? extends GenericMethods>> list) {
    }

    public static void main(String[] args) {
        f(New.map());
    }
}


class GenericVarargs {
    public static <T> List<T> makeList(T... args) {
        List<T> list = new ArrayList<>();
        for (T i : args) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = makeList("A");
        System.out.println(list);
        List<String> makeList = makeList("A", "B", "C");
        System.out.println(makeList);
        List<String> strings = makeList("abcdefghijklmnopqrstuvwxyz".split(""));
        System.out.println(strings);
    }
}