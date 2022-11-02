package com.thinking.initializecleanup;

/**
 * @author 李昭
 * @Date 7:53 2020/5/15
 * @Description:
 * @Modified By:
 */
public class Flower {
    int petalCount = 0;
    String s = "initial value";

    public Flower(int petalCount) {
        this.petalCount = petalCount;
        System.out.println("Constructor int arg only, petalCount = " + petalCount);
    }

    public Flower(String s) {
        System.out.println("Constructor com.thinking.string arg only, s = "+ s);
        this.s = s;
    }

    public Flower(int petalCount, String s) {
        this(petalCount);
        /**
         * 在一个构造器中不能重复调用两次其他的构造器,因为只能初始化一个对象
         */
//        this(s);
    }
}
