package com.thinking.innerstudycollection.fillcollection;

import java.util.*;

/**
 * @Author 李昭
 * @Date 2020/6/24 11/45
 */
public class CountingMapData extends AbstractMap<Integer, String> {

    private int size;
    private static String[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

    public CountingMapData(int size) {
        this.size = size < 0 ? 0 : size;
    }

    private static class Entry implements Map.Entry<Integer, String> {

        int index;

        Entry(int index) {
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            return Integer.valueOf(index).equals(o);
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return chars[index % chars.length] + index / chars.length;
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }
    }


    public static class EntrySet extends AbstractSet<Map.Entry<Integer, String>> {

        int size;

        EntrySet(int size) {
            this.size = size < 0 ? 0 : size > chars.length ? chars.length : size;
        }


        @Override
        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new Iter();
        }

        @Override
        public int size() {
            return size;
        }

        static class Iter implements Iterator<Map.Entry<Integer, String>> {

            private Entry entry = new Entry(-1);


            @Override
            public boolean hasNext() {
                return entry.index < chars.length;
            }

            @Override
            public Map.Entry<Integer, String> next() {
                entry.index++;
                return entry;
            }
        }
    }


    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        Set<Map.Entry<Integer, String>> entries = new LinkedHashSet<>();
        for (int i = 0; i < size; i++) {
            entries.add(new Entry(i));
        }
        return entries;
//        return new EntrySet(20);
    }

    public static void main(String[] args) {
        System.out.println(new CountingMapData(60));
    }
}
