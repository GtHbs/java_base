package com.on_java.interfaces;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/10/24 23:05
 */
public class ImplementConflict implements JimA, JimB {

    /**
     * If there is a duplicate default method in multiple com.thinking.interfaces implemented,
     * the method must be overridden or the compilation fails.
     * for example
     */
    @Override
    public void jim() {
        JimA.super.jim();
    }
}



interface JimA {

    default void jim() {
        System.out.println("JimA");
    }
}


interface JimB {
    default void jim() {
        System.out.println("JimB");
    }
}


