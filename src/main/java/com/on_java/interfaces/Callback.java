package com.on_java.interfaces;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/10/26 22:48
 */
public class Callback {

    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
//        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackRef());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }

}


interface Incremental {
    void increment();
}

class Callee1 implements Incremental {

    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement {
    public void increment() {
        System.out.println("other operation");
    }

    static void f(MyIncrement mi) {
        mi.increment();
    }
}

/**
 * 此类的核心在于在接口和父类拥有同样的方法或者属性时，
 * 子类无法做到同时重写，所以需要使用内部类代替外部类实现接口或者继承父类
 */
class Callee2 extends MyIncrement {

    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }


    private class Closure implements Incremental {

        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }


    Incremental getCallbackRef() {
        return new Closure();
    }
}


class Caller {
    private final Incremental callbackRef;

    public Caller(Incremental callbackRef) {
        this.callbackRef = callbackRef;
    }

    void go() {
        callbackRef.increment();
    }
}