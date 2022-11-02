package com.thinking.exception;

/**
 * @Author 李昭
 * @Date 2020/6/11 20/27
 */
public class SimpleException extends Exception {

}

class InheritingExceptions {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions exceptions = new InheritingExceptions();
        try {
            exceptions.f();
        } catch (SimpleException e) {
            System.out.println("Caught it()");
        }
    }
}

class MyException extends Exception {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}

class FullConstructors {
    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            //这种方式将错误信息输出到标准输出流,默认为错误流为System.err
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }
}