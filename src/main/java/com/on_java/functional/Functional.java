package com.on_java.functional;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/11/2 21:45
 */
@FunctionalInterface
public interface Functional {

    String bye(String arg);
}


interface FunctionalNoAnn {
    String bye(String arg);
}


class FunctionalAnnotation {


    public String bye(String arg) {
        return "bye " + arg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation annotation = new FunctionalAnnotation();
        Functional f = annotation::bye;
        FunctionalNoAnn fa = annotation::bye;
        Functional fl = a -> "Bye " + a;
        FunctionalNoAnn fla = a -> "Bye No Ann " + a;
    }

}