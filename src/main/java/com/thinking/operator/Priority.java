package com.thinking.operator;

import org.junit.Test;

import static com.thinking.operator.util.Print.print;

/**
 * @author 李昭
 * @Date 7:44 2020/5/12
 * @Description:
 * @Modified By:
 */
public class Priority {
    public static void main(String[] args) {
        int x = 1, y = 2, z = 3;
        int a = x + y - 2 / 2 + z;
        int b = x + (y - 2) / (2 + z);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    @Test
    public void test() {
        Tank t1 = new Tank();
        Tank t2 = new Tank();
        t1.level = 9;
        t2.level = 47;
        System.out.println("t1.level = " + t1.level);
        System.out.println("t2.level = " + t2.level);
        t1 = t2;
        System.out.println("t1.level = " + t1.level);
        System.out.println("t2.level = " + t2.level);
        t1.level = 27;
        System.out.println("t1.level = " + t1.level);
        System.out.println("t2.level = " + t2.level);
    }

    @Test
    public void testMethodAlias() {
        Letter letter = new Letter();
        letter.c = 'a';
        print("1: letter.c:" + letter.c);
        f(letter);
        print("2: letter.c:" + letter.c);
    }

    /**
     * 传进来的为对象的引用
     *
     * @param letter
     */
    static void f(Letter letter) {
        letter.c = 'z';
    }
}

class Tank {
    int level;
}

class Letter {
    char c;
}