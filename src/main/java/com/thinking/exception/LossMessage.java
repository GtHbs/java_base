package com.thinking.exception;

/**
 * @Author 李昭
 * @Date 2020/6/14 21/03
 */
public class LossMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LossMessage message = new LossMessage();
            try {
                message.f();
            } finally {
                //finally中抛出的异常会将try中抛出的异常覆盖
                message.dispose();
            }
        } catch (VeryImportantException e) {
            System.out.println(e);
        } catch (HoHumException e) {
            System.out.println(e);
        }
    }
}

class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "A very important com.thinking.exception!";
    }

}

class HoHumException extends Exception {

    @Override
    public String toString() {
        return "A trivial com.thinking.exception!";
    }
}

class ExceptionSilencer {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            return;
        }
    }
}
