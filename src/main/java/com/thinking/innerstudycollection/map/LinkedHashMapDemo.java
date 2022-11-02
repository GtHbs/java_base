package com.thinking.innerstudycollection.map;

import com.thinking.innerstudycollection.fillcollection.CountingMapData;

import java.util.LinkedHashMap;

/**
 * @Author 李昭
 * @Date 2020/6/27 09/23
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(new CountingMapData(9));
        System.out.println(map);
        /**
         * 第三个参数的意思为是否使用最近最少使用算法,如果使用,则最新被访问的元素会被放在最后,
         * 没有被访问的元素会被放在前面
         */
        map = new LinkedHashMap<>(16, 0.75f, true);
        map.putAll(new CountingMapData(9));
        System.out.println(map);
        for (int i = 0; i < 6; i++) {
            map.get(i);
        }
        System.out.println(map);
        map.get(0);
        map.get(1);
        System.out.println(map);
    }
}
