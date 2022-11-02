package com.thinking.generic;

import java.util.*;

/**
 * @Author 李昭
 * @Date 2020/6/19 21/10
 */
public class BigFish {

    private static long counter = 1;
    private final long id = counter++;

    private BigFish() {

    }

    public static Generator<BigFish> generator() {
        return () -> new BigFish();
    }

    @Override
    public String toString() {
        return "BigFish: " + id;
    }
}

class LittleFish {
    private static long counter = 1;
    private final long id = counter++;

    private LittleFish() {

    }

    public static Generator<LittleFish> generator() {
        return () -> new LittleFish();
    }

    @Override
    public String toString() {
        return "LittleFish: " + id;
    }
}

class Ocean {
    public static void eat(BigFish bigFish, LittleFish littleFish) {
        System.out.println(bigFish + " eat " + littleFish);
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<BigFish> queue = new LinkedList<>();
        Generators.fill(queue, BigFish.generator(), 3);
        List<LittleFish> littleFish = new ArrayList<>();
        Generators.fill(littleFish, LittleFish.generator(), 30);
        for (BigFish fish : queue) {
            eat(fish, littleFish.get(random.nextInt(littleFish.size())));
        }
    }
}
