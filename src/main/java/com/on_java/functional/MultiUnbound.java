package com.on_java.functional;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/10/31 23:25
 */
public class MultiUnbound {

    public static void main(String[] args) {
        TwoArgs twoArgs = This::two;
        ThreeArgs threeArgs = This::three;
        FourArgs fourArgs = This::four;
        This aThis = new This();
        twoArgs.call2(aThis, 1, 2.2);
        threeArgs.call3(aThis, 1, 2.2, "s");
        fourArgs.call4(aThis, 1, 2.2, "s", 'c');
    }
}


class This {
    void two(int i, double d) {

    }

    void three(int i, double d, String s) {

    }

    void four(int i, double d, String s, char c) {

    }
}

interface TwoArgs {
    void call2(This athis, int i, double d);
}

interface ThreeArgs {
    void call3(This athis, int i, double d, String s);
}

interface FourArgs {
    void call4(This athis, int i, double d, String s, char c);
}