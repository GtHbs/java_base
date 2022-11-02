package com.thinking.innerstudycollection.fillcollection;

import com.thinking.array.arrayandgeneric.CountingGenerator;
import com.thinking.array.arrayandgeneric.RandomGenerator;
import com.thinking.generic.Generator;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @Author 李昭
 * @Date 2020/6/22 22/14
 */
public class Pair<K, V> {
    public final K key;
    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class MapData<K, V> extends LinkedHashMap<K, V> {
    public MapData(Generator<Pair<K, V>> generator, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> pair = generator.next();
            put(pair.key, pair.value);
        }
    }

    public MapData(Generator<K> key, Generator<V> val, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(key.next(), val.next());
        }
    }

    public MapData(Generator<K> key, V val, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(key.next(), val);
        }
    }


    public MapData(Iterable<K> key, Generator<V> val) {
        for (K k : key) {
            put(k, val.next());
        }
    }

    public MapData(Iterable<K> key, V val) {
        for (K k : key) {
            put(k, val);
        }
    }

    public static <K,V> MapData<K,V> map(Generator<Pair<K,V>> generator,int quantity) {
        return new MapData<>(generator,quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> key, Generator<V> val, int quantity) {
        return new MapData<>(key, val, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> key, V val, int quantity) {
        return new MapData<>(key, val, quantity);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> key, Generator<V> val) {
        return new MapData<>(key, val);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> key, V val) {
        return new MapData<>(key, val);
    }
}

class Letters implements Generator<Pair<Integer, String>> {

    private int size = 9;
    private int number = 1;
    private char letter = 'A';

    @Override
    public Pair<Integer, String> next() {
        return new Pair<Integer, String>(number++, "" + letter++);
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {


            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

class MapDataTest {
    public static void main(String[] args) {
        System.out.println(MapData.map(new Letters(),11));
        System.out.println(MapData.map(new CountingGenerator.Character(),new RandomGenerator.Integer(),8));
        System.out.println(MapData.map(new CountingGenerator.Character(),"Value",11));
    }
}