package com.thinking.containsobject;

/**
 * @author lizhao
 * @Date 2020/10/13 9:28
 */
public class A {
    private void hello(String n) {
        System.out.println(n +"-");
    }
}
class B extends A implements c {
    public void hello(String n) {
        System.out.println(n);
    }

    public static void main(String[] args) {
        B b = new B();
        b.hello();
    }
}
interface c {
    default void hello() {
        System.out.println("hello");
    }
}