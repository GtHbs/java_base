package com.thinking.innerstudycollection.hashcode;

import com.thinking.innerstudycollection.fillcollection.Countries;

import java.util.*;

/**
 * 使用List实现Map
 *
 * @Author 李昭
 * @Date 2020/6/27 10/07
 */
public class SlowMap<K, V> extends AbstractMap<K, V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    @Override
    public V put(K key, V value) {
        //这个值可能为空,需要进行二次判断
        V oldValue = get(key);
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        if (!keys.contains(key)) {
            return null;
        }
        return values.get(keys.indexOf(key));
    }


    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext()) {
            set.add(new MapEntry<>(ki.next(), vi.next()));
        }
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String, String> map = new SlowMap<>();
        map.putAll(Countries.capitals(15));
        System.out.println(map);
        System.out.println(map.entrySet());
    }
}

/**
 * 工具类: 可以存储Entry对象,而不用每次使用匿名内部类的形式实现
 */
class MapEntry<K, V> implements Map.Entry<K, V> {

    private K key;
    private V value;


    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V v) {
        V result = value;
        value = v;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MapEntry)) {
            return false;
        }
        MapEntry me = (MapEntry) o;
        return (key == null ? me.getKey() == null : key.equals(me.getKey()))
                && (value == null ? me.getValue() == null : value.equals(me.getValue()));
    }

    @Override
    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}

/**
 * 使用Map实现计数器功能<br>
 */
class SlowMap2<K> extends AbstractMap<K, Integer> {

    private List<K> keys = new ArrayList<>();
    private List<Integer> values = new ArrayList<>();


    @Override
    public Integer get(Object key) {
        if (!keys.contains(key)) {
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    public Integer put(K key) {
        Integer oldValue = get(key);
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(1);
        } else {
            Integer count = values.get(keys.indexOf(key));
            values.set(keys.indexOf(key), ++count);
        }
        return oldValue;
    }


    @Override
    public Set<Entry<K, Integer>> entrySet() {
        Set<Map.Entry<K, Integer>> set = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<Integer> vi = values.iterator();
        while (ki.hasNext()) {
            set.add(new MapEntry<>(ki.next(), vi.next()));
        }
        return set;
    }


    public static void main(String[] args) {
        SlowMap2<String> map2 = new SlowMap2<>();
        map2.put("s");
        map2.put("s");
        map2.put("d");
        map2.put("f");
        map2.put("d");
        map2.put("s");
        System.out.println(map2);
    }
}