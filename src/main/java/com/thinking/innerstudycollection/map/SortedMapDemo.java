package com.thinking.innerstudycollection.map;

import com.thinking.innerstudycollection.fillcollection.CountingMapData;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * @Author 李昭
 * @Date 2020/6/27 09/09
 */
public class SortedMapDemo {

    public static void test() {
        /**
         * 使用填充器填充,没有实现Comparator或Comparable因此为自然排序,
         * 如果要填入的对象实现了Comparator或Comparable则可以按照自定义规则进行排序
         */
        TreeMap<Integer, String> map = new TreeMap<>(new CountingMapData(25));
        System.out.println(map);
        Integer low = map.firstKey();
        Integer high = map.lastKey();
        System.out.println(low);
        System.out.println(high);
        Iterator<Integer> iterator = map.keySet().iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3) {
                low = iterator.next();
            } else if (i == 6) {
                high = iterator.next();
            } else {
                iterator.next();
            }
        }
        System.out.println(low);
        System.out.println(high);
        //截取map
        System.out.println(map.subMap(low, high));
        //获取比high小的key的entry组成一个新的map
        System.out.println(map.headMap(high));
        //获取比low大的key的entry组成一个新的map
        System.out.println(map.tailMap(low));
    }

    public static void test02() {
        TreeMap<Double, Apple> map = new TreeMap<>();
        map.put(12.2, new Apple(12.2, "A"));
        map.put(2.2, new Apple(2.2, "B"));
        map.put(22.2, new Apple(22.2, "C"));
        map.put(1.2, new Apple(1.2, "D"));
        map.put(16.2, new Apple(16.2, "E"));
        map.put(12.4, new Apple(12.4, "F"));
        map.put(12.6, new Apple(12.6, "G"));
        map.put(0.2, new Apple(0.2, "H"));
        map.put(22.1, new Apple(22.1, "I"));
        map.put(9.2, new Apple(9.2, "J"));
        System.out.println(map);
    }

    public static void main(String[] args) {
        test02();
    }
}

/**
 * 按照重量倒序排序
 */
class Apple implements Comparable<Apple> {
    double wight;
    String color;

    public double getWight() {
        return wight;
    }

    public String getColor() {
        return color;
    }

    public void setWight(double wight) {
        this.wight = wight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Apple(double wight, String color) {
        this.wight = wight;
        this.color = color;
    }

    @Override
    public int compareTo(Apple o) {
        return (int) (o.wight - this.wight);
    }

    @Override
    public String toString() {
        return color + " : " + wight;
    }
}
