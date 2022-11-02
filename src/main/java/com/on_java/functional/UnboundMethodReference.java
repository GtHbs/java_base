package com.on_java.functional;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/10/31 23:16
 */
public class UnboundMethodReference {

    public static void main(String[] args) {
//        MakeString ms = X::f;
        TransformX sp = X::f;
        X x = new X();
        System.out.println(sp.transform(x));
        System.out.println(x.f());
    }
}

class X {
    String f() {
        return "X::f";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}