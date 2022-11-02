package com.thinking.generic;

/**
 * @Author 李昭
 * @Date 2020/6/18 19/32
 */
public class Holder {

    private Object a;

    public Holder(Object a) {
        this.a = a;
    }

    public void set(Object a) {
        this.a = a;
    }

    public Object get() {
        return a;
    }

    public static void main(String[] args) {
        /**
         * 使用Object类可以接收任意类型的对象
         */
        Holder holder = new Holder(new AutoMobile());
        AutoMobile o = (AutoMobile) holder.get();
        String o1 = (String) holder.get();
    }
}
class AutoMobile {

}


class Holder2<T> {
    private T t;

    public Holder2(T t) {
        this.t = t;
    }
    public void set(T t) {
        this.t = t;
    }
    public T get() {
        return t;
    }

    public static void main(String[] args) {
        /**
         * 使用泛型就可以接收任意单一类型的对象
         */
        Holder2<AutoMobile> mobile = new Holder2<>(new AutoMobile());
        AutoMobile autoMobile = mobile.get();
    }
}