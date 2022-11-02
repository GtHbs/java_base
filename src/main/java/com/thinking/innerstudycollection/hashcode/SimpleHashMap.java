package com.thinking.innerstudycollection.hashcode;

import com.thinking.innerstudycollection.fillcollection.Countries;

import java.util.*;

/**
 * 实现简单的散列Map
 *
 * @Author 李昭
 * @Date 2020/6/27 10/49
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    static final int SIZE = 997;
    /**
     * 装元素使用的桶
     */
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        //获取当前元素所在桶的下标
        int index = Math.abs(key.hashCode()) % SIZE;
        //当前位置为空,创建一个桶
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        //获取当前的桶
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        //需要插入的值
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            int count = 0;
            MapEntry<K, V> iPair = it.next();
            //如果之前已经将该值插入进去了,则替换为新值
            if (iPair.getKey().equals(key)) {
                System.out.println("=================冲突===============");
                System.out.println("查找次数: " + count);
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
            count++;
        }
        //之前桶里面没有该值,则插入该值
        if (!found) {
            buckets[index].add(pair);
        }
        return oldValue;
    }


    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            return null;
        }
        for (MapEntry<K, V> iPair : buckets[index]) {
            if (iPair.getKey().equals(key)) {
                return iPair.getValue();
            }
        }
        return null;
    }


    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) {
                continue;
            }
            for (MapEntry<K, V> entry : bucket) {
                set.add(entry);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.putAll(Countries.capitals(25));
        System.out.println(map);
        System.out.println(map.entrySet());
    }
}
