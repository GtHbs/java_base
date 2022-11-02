package com.thinking.enumeration.basic;

import com.thinking.generic.Generator;

import java.util.Random;

/**
 * @Author 李昭
 * @Date 2020/7/13 08/09
 */
public class EnumImplementation {
    public static <T> void printNext(Generator<T> g) {
        System.out.print(g.next() +", ");
    }
    public static <T> void printNext() {
        System.out.print(CartoonCharacter.next() + ", ");
    }

    public static void main(String[] args) {
        CartoonCharacter c = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
//            printNext(c);
            printNext();
        }
    }
}

@SuppressWarnings("all")
enum CartoonCharacter /*implements Generator<CartoonCharacter>*/ {
    SLAPPY,SPANKY,PUNCHY,SILLY,BOUNCY,NUTTY,BOB;

    private Random random = new Random(47);
    private static Random r = new Random(48);
//    @Override
//    public CartoonCharacter next() {
//        return values()[random.nextInt(values().length)];
//    }
    static CartoonCharacter next() {
        return values()[r.nextInt(values().length)];
    }
}
