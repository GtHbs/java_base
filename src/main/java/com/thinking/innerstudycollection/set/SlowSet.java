package com.thinking.innerstudycollection.set;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author 李昭
 * @Date 2020/6/27 10/36
 */
public class SlowSet<K> extends AbstractSet<K> {

    private List<K> keys = new ArrayList<>();


    public K get(int index) {
        if (index >= keys.size()) {
            return null;
        }
        return keys.get(index);
    }

    public K set(int index, K key) {
        K oldValue = get(index);
        if (get(index) == null) {
            keys.add(key);
        } else {
            keys.set(index, key);
        }
        return oldValue;
    }

    @Override
    public boolean add(K key) {
        if (!keys.contains(key)) {
            return keys.add(key);
        }
        return false;
    }


    @Override
    public Iterator<K> iterator() {
        return keys.iterator();
    }

    @Override
    public int size() {
        return keys.size();
    }

    public static void main(String[] args) {
        SlowSet<String> set = new SlowSet<>();
        set.add("a");
        set.add("a");
        set.add("a");
        System.out.println(set);
        System.out.println(set.get(10));
    }
}
