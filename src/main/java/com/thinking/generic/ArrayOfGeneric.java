package com.thinking.generic;


import java.lang.reflect.Array;

/**
 * @Author 李昭
 * @Date 2020/6/20 18/05
 */
public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;

    public static void main(String[] args) {
        //ClassCastException
        //gia = (Generic<Integer>[]) new Object[SIZE];
        //在类加载时已经将泛型类型确定了
        gia = new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<>();
    }
}

class Generic<T> {
}


class GenericArray<T> {
    private T[] array;

    public GenericArray(int size) {
        array = (T[]) new Object[size];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> array = new GenericArray<>(10);
        java.lang.Object[] rep = array.rep();
        //ClassCastException,对于对象(数组)是不能进行强转的
        Integer[] integers = array.rep();
    }
}

class GenericArrayWithTypeToken<T> {
    private T[] array;

    public GenericArrayWithTypeToken(Class<T> type, int size) {
        array = (T[]) Array.newInstance(type, size);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> token = new GenericArrayWithTypeToken<>(Integer.class, 10);
        Integer[] rep = token.rep();
    }
}