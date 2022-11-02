package com.thinking.innerstudycollection.map;

/**
 * @Author 李昭
 * @Date 2020/6/25 21/40
 */
public class AssociativeArray<K, V> {
    private Object[][] pairs;
    private int index;

    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    /**
     * 词频判断器
     */
    public void put(K key, V val) {
        if (index >= pairs.length) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < index; i++) {
            if (key.equals(pairs[i][0])) {
                Integer count = (Integer) pairs[i][1];
                pairs[i][1] = count++;
                return;
            }
        }
        pairs[index++] = new Object[]{key, val};
    }

    public boolean contains(K key) {
        for (int i = 0; i < index; i++) {
            if (key.equals(pairs[i][0])) {
                return true;
            }
        }
        return false;
    }


    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key.equals(pairs[i][0])) {
                return (V) pairs[i][1];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < index; i++) {
            builder.append(pairs[i][0].toString());
            builder.append(" : ");
            builder.append(pairs[i][1].toString());
            if (i < index - 1) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        AssociativeArray<String, String> map = new AssociativeArray<>(6);
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "Object");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Too many objects");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));
    }
}
