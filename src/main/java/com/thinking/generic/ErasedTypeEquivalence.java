package com.thinking.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author 李昭
 * @Date 2020/6/19 21/38
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class<? extends ArrayList> aClass = new ArrayList<Integer>().getClass();
        Class<? extends ArrayList> bClass = new ArrayList<String>().getClass();
        /**
         * true
         * 泛型擦除
         */
        System.out.println(aClass == bClass);
    }
}


class Frob {

}

class Fnorkle {

}

class Quark<Q> {

}

class LostInformation {
    public static void main(String[] args) {
        ArrayList<Frob> frobs = new ArrayList<>();
        HashMap<Frob, Fnorkle> map = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>();
        /**
         * 不能获取到泛型类型参数的信息
         */
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(frobs.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
    }
}