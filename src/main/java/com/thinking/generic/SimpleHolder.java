package com.thinking.generic;

/**
 * @Author 李昭
 * @Date 2020/6/20 16/42
 */
public class SimpleHolder {
    private Object obj;
    public void set(Object obj) {
        this.obj = obj;
    }
    public Object get() {
        return obj;
    }

    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder();
        holder.set("Item");
        String o = (String) holder.get();
        System.out.println(o);
    }
}


class GenericHolder<T> {
    private T obj;
    public void set(T obj) {
        this.obj = obj;
    }
    public T get() {
        return obj;
    }

    public static void main(String[] args) {
        GenericHolder<String> holder = new GenericHolder<>();
        holder.set("Item");
        //因为泛型的作用,在获取时,由编译器帮助我们进行类型强转,不需要像上面那样手动进行类型强转
        String s = holder.get();
    }
}