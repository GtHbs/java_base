package com.thinking.exception;

/**
 * @Author 李昭
 * @Date 2020/6/14 19/12
 */
public class Switch {
    private boolean state = false;

    public boolean read() {
        return state;
    }

    public void on() {
        state = true;
        System.out.println(this);
    }

    public void off() {
        state = false;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return state ? "on" : "off";
    }
}

class OnOffException1 extends Exception {
}

class OnOffException2 extends Exception {
}


class OnOffSwitch {
    private static Switch aSwitch = new Switch();

    public static void f() throws OnOffException1, OnOffException2 {
    }

    public static void main(String[] args) {
        try {
            aSwitch.on();
            f();
            aSwitch.off();
            throw new RuntimeException();
        } catch (OnOffException1 onOffException1) {
            System.out.println("OnOffException1");
        } catch (OnOffException2 onOffException2) {
            System.out.println("OnOffException2");
        } finally {
            aSwitch.off();
        }
    }
}

class WithFinally {
    static Switch aSwitch = new Switch();

    public static void main(String[] args) {
        try {
            aSwitch.on();
            OnOffSwitch.f();
            throw new RuntimeException();
        } catch (OnOffException2 onOffException2) {
            System.out.println("OnOffException1");
        } catch (OnOffException1 onOffException1) {
            System.out.println("OnOffException2");
        } finally {
            aSwitch.off();
        }
    }
}

class AlwaysFinally {
    public static void main(String[] args) {
        System.out.println("Entering first try block");
        try {
            throw new FourException();
        } catch (FourException e) {
            System.out.println("Caught FourException in 1st try block");
        } finally {
            System.out.println("finally in 1st try block");
        }
    }
}

class FourException extends Exception {


    public static void main(String[] args) {
        try {
            //子类异常不能捕获父类异常(异常捕获只能捕获比自己类型小的(除了Exception和RuntimeException))
            throw new RuntimeException();
        } catch (NullPointerException e) {
            System.out.println("aaaa");
        }
    }
}