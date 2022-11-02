package com.on_java.functional;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/10/31 23:02
 */
public class RecursiveFibonacci {

    Call call;

    RecursiveFibonacci() {
        call = n -> n == 0 ? 0 : n == 1 ? 1 : call.call(n - 1) + call.call(n - 2);
    }

    int fibonacci(int n) {
        return call.call(n);
    }

    public static void main(String[] args) {
        RecursiveFibonacci fibonacci = new RecursiveFibonacci();
        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacci.fibonacci(i));
        }
    }
}
