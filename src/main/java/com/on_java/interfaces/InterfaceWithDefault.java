package com.on_java.interfaces;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/10/24 22:58
 */
public interface InterfaceWithDefault {



    void f();

    void d();

    default void hello(String value) {
        System.out.println(value);
    }

}


class InterfaceWithDefaultImplements implements InterfaceWithDefault {

    @Override
    public void f() {
        System.out.println("f()");
    }

    @Override
    public void d() {
        System.out.println("d()");
    }
}

class DefaultTest {
    public static void main(String[] args) {
        InterfaceWithDefault interfaceWithDefault = new InterfaceWithDefaultImplements();
        interfaceWithDefault.f();
        interfaceWithDefault.d();
        interfaceWithDefault.hello("hello world");
    }
}