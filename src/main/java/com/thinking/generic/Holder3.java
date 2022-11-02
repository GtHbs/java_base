package com.thinking.generic;

/**
 * @Author 李昭
 * @Date 2020/6/20 21/17
 */
public class Holder3<T> {
    private T t;

    public Holder3() {
    }

    public Holder3(T t) {
        this.t = t;
    }
    public void set(T val) {
        this.t = val;
    }
    public T get() {
        return t;
    }
    @Override
    public boolean equals(Object obj) {
        return t.equals(obj);
    }
}
