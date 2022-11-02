package com.thinking.exception;

/**
 * @Author 李昭
 * @Date 2020/6/13 21/48
 */
public class WhoCalled {
    static void f() {
        try {
            throw new Exception();
        } catch (Exception e) {
            /**
             * 获取异常调用链
             */
            for (StackTraceElement element : e.getStackTrace()) {
                System.out.println(element.getMethodName());
            }
        }
    }

    static void g() {
        f();
    }

    static void h() {
        g();
    }

    public static void main(String[] args) {
        f();
        System.out.println("------------------------------");
        g();
        System.out.println("------------------------------");
        h();
    }
}

class ReThrowException {
    static void f() {
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            /**
             * 在此抛出的异常,后面的捕获都不会执行
             */
            throw e;
        } catch (RuntimeException e) {
            System.out.println("RuntimeException");
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    static void g() {
        f();
    }

    public static void main(String[] args) {
        g();
    }
}


class RethrowingException {
    static void f() throws Exception {
        System.out.println("originating the com.thinking.exception in f()");
        throw new Exception("thrown from f()");
    }

    static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside g(),e.printStackTrace()");
            e.printStackTrace(System.out);
            throw e;
        }
    }

    public static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside h(), e.printStackTrace()");
            e.printStackTrace(System.out);
            /**
             * 该行的意思为更新异常调用栈信息
             */
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
        try {
            h();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}

class OneException extends Exception {
    public OneException(String message) {
        super(message);
    }
}

class TwoException extends Exception {
    public TwoException(String message) {
        super(message);
    }
}


class RethrowNew {
    static void f() throws OneException {
        System.out.println("originating the com.thinking.exception in f()");
        throw new OneException("thrown from f()");
    }

    public static void main(String[] args) {
        try {
            try {
                f();
            } catch (OneException e) {
                System.out.println("Caught in inner try,e.printStackTrace()");
                e.printStackTrace(System.out);
                throw new TwoException("from inner try");
            }
        } catch (TwoException e) {
            System.out.println("Caught in outer try,e.printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}