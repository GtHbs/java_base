package com.thinking.innerstudycollection.usagemethod;

import com.thinking.innerstudycollection.fillcollection.Countries;

import java.util.*;

/**
 * 创建只读的容器
 *
 * @Author 李昭
 * @Date 2020/7/1 08/13
 */
public class ReadOnly {
    static Collection<String> data = new ArrayList<>(Countries.names(6));

    public static void main(String[] args) {
        Collection<String> c = Collections.unmodifiableCollection(new ArrayList<>(data));
        System.out.println(c);
        List<String> a = Collections.unmodifiableList(new ArrayList<>(data));
        ListIterator<String> lit = a.listIterator();
        System.out.println(lit.next());
        Set<String> s = Collections.unmodifiableSet(new HashSet<>(data));
        System.out.println(s);
        SortedSet<String> ss = Collections.unmodifiableSortedSet(new TreeSet<>(data));
        System.out.println(ss);
        Map<String, String> m = Collections.unmodifiableMap(new HashMap<>(Countries.capitals(6)));
        System.out.println(m);
        SortedMap<String, String> sm = Collections.unmodifiableSortedMap(new TreeMap<>(Countries.capitals(6)));
        System.out.println(sm);
    }
}
