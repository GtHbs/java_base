package com.thinking.innerstudycollection.fillcollection;

import org.junit.Test;

import java.util.*;

/**
 * @Author 李昭
 * @Date 2020/6/24 10/27
 */
public class Countries {

    public static final String[][] DATA = new String[100][2];

    /**
     * 初始化数组值
     */
    static {
        Random random = new Random(47);
        for (int i = 0; i < 100; i++) {
            DATA[i] = new String[]{String.valueOf(random.nextInt(100000)), String.valueOf(random.nextInt(100000))};
        }
    }

    private static class FlyweightMap extends AbstractMap<String, String> {

        private static Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);

        @Override
        public Set<Map.Entry<String, String>> entrySet() {
            return entries;
        }

        /**
         * 节点元素(hash表中存放的元素)
         */
        private static class Entry implements Map.Entry<String, String> {

            int index;

            Entry(int index) {
                this.index = index;
            }

            @Override
            public boolean equals(Object o) {
                return DATA[index][0].equals(o);
            }

            @Override
            public int hashCode() {
                return DATA[index][0].hashCode();
            }

            @Override
            public String getKey() {
                return DATA[index][0];
            }

            @Override
            public String getValue() {
                return DATA[index][1];
            }

            @Override
            public String setValue(String value) {
                throw new UnsupportedOperationException();
            }
        }

        /**
         * 获取所有的元素
         */
        static class EntrySet extends AbstractSet<Map.Entry<String, String>> {

            private int size;

            EntrySet(int size) {
                if (size < 0) {
                    this.size = 0;
                } else if (size > DATA.length) {
                    this.size = DATA.length;
                } else {
                    this.size = size;
                }
            }


            @Override
            public Iterator<Map.Entry<String, String>> iterator() {
                return new Iter();
            }

            @Override
            public int size() {
                return size;
            }

            private class Iter implements Iterator<Map.Entry<String, String>> {

                private Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index < size - 1;
                }

                @Override
                public Map.Entry<String, String> next() {
                    entry.index++;
                    return entry;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }

        }
    }

    static Map<String, String> select(final int size) {
        return new FlyweightMap() {
            @Override
            public Set<Map.Entry<String, String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }

    static Map<String, String> map = new FlyweightMap();

    public static Map<String, String> countries() {
        return map;
    }

    public static Map<String, String> capitals(int size) {
        return select(size);
    }

    static List<String> names = new ArrayList<>(map.keySet());

    public static List<String> names() {
        return names;
    }

    public static List<String> names(int size) {
        return new ArrayList<>(select(size).keySet());
    }

    public static void main(String[] args) {
        System.out.println(capitals(10));
        System.out.println(names(10));
        System.out.println(new HashMap<String, String>(capitals(3)));
        System.out.println(new LinkedHashMap<String, String>(capitals(3)));
        System.out.println(new TreeMap<String, String>(capitals(3)));
        System.out.println(new Hashtable<String, String>(capitals(3)));
        System.out.println(new HashSet<>(names(6)));
        System.out.println(new LinkedHashSet<>(names(6)));
        System.out.println(new TreeSet<>(names(6)));
        System.out.println(new ArrayList<>(names(6)));
        System.out.println(new LinkedList<>(names(6)));
    }

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < DATA.length; i++) {
            list.add(DATA[i][0]);
        }
        Arrays.sort(list.toArray());
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }

}
