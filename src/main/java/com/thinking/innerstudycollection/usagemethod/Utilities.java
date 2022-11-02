package com.thinking.innerstudycollection.usagemethod;

import java.util.*;

/**
 * @Author 李昭
 * @Date 2020/7/1 07/23
 */
public class Utilities {
    public static List<String> list = Arrays.asList("one two three Four five six seven eight nine one".split(" "));

    public static void main(String[] args) {
        System.out.println(list);
        //两个集合没有任何相同元素时,返回true
        System.out.println("'list' disjoint('four') ?:" + Collections.disjoint(list, Collections.singletonList("four")));
        //字符型默认按照字典排序
        System.out.println("max: " + Collections.max(list));
        System.out.println("min: " + Collections.min(list));
        /**
         * CASE_INSENSITIVE_ORDER:在比较的集合中取较短的那一个字符,然后循环判断两个字符串的第一个ASCII大小进行排序
         */
        System.out.println("max w/ comparator: " + Collections.max(list, String.CASE_INSENSITIVE_ORDER));
        System.out.println("min w/ comparator: " + Collections.min(list, String.CASE_INSENSITIVE_ORDER));

        List<String> subList = Arrays.asList("four five six".split(" "));
        System.out.println("indexOfSubList: " + Collections.indexOfSubList(list, subList));
        System.out.println("lastIndexOfSubList: " + Collections.lastIndexOfSubList(list, subList));
        Collections.replaceAll(list, "one", "yo");
        System.out.println("replaceAll: " + list);
        Collections.reverse(list);
        System.out.println("reverse: " + list);
        //将所有的元素向后移动3个位置,最后的元素移动到前面来
        Collections.rotate(list, 3);
        System.out.println("rotate: " + list);
        List<String> source = Arrays.asList("in the matrix".split(" "));
        //将source中的元素复制到list中
        Collections.copy(list, source);
        System.out.println("copy: " + list);
        //交换两个位置得元素
        Collections.swap(list, 0, list.size() - 1);
        System.out.println("swap: " + list);
        Collections.shuffle(list, new Random(47));
        System.out.println("shuffled: " + list);
        Collections.fill(list, "pop");
        System.out.println("fill: " + list);
        //查看某个元素出现的次数
        System.out.println("frequency of 'pop': " + Collections.frequency(list, "pop"));
        List<String> dups = Collections.nCopies(3, "snap");
        System.out.println("dups:" + dups);
        System.out.println("'list' disjoint 'dups'?: " + Collections.disjoint(list,dups));

        Enumeration<String> e = Collections.enumeration(dups);
        Vector<String> v = new Vector<>();
        while (e.hasMoreElements()) {
            v.addElement(e.nextElement());
        }
        ArrayList<String> arrayList = Collections.list(v.elements());
        System.out.println("arrayList: " + arrayList);

    }
}
