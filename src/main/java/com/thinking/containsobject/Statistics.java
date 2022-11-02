package com.thinking.containsobject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author: 李昭
 * @Date: 2020/6/9 19:52
 */
public class Statistics {
    public static void main(String[] args) {
        Random random = new Random(47);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int r = random.nextInt(20);
            Integer freq = map.get(r);
            map.put(r, freq == null ? 1 : freq + 1);
        }
        System.out.println(map);
    }
}
