package com.thinking.reusedclass;

/**
 * @author 李昭
 * @Date 7:53 2020/5/20
 * @Description:
 * @Modified By:
 */
public class A extends C {
    public A() {
        System.out.println("A");
    }

    public static void main(String[] args) {
        C c = new C();
    }
}
class B {
    public B() {
        System.out.println("B");
    }
}
class C {
    B b = new B();
}
