package com.on_java.functional;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/10/31 23:00
 */
public class RecursiveFactories {

    static Call call;

    public static void main(String[] args) {
        call = n -> n == 0 ? 1 : n * call.call(n - 1);
        for (int i = 0; i < 10; i++) {
            System.out.println(call.call(i));
        }
    }
}


interface Call {
    int call(int n);
}