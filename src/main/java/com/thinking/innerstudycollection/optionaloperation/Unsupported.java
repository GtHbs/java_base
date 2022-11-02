package com.thinking.innerstudycollection.optionaloperation;

import java.util.*;

/**
 * @Author 李昭
 * @Date 2020/6/24 17/31
 */
@SuppressWarnings("all")
public class Unsupported {
    static void test(String msg, List<String> list) {
        System.out.println("---------" + msg + "--------");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);
        Collection<String> c2 = new ArrayList<>(subList);
        try {
            //只保留和c2中一样的元素
            c.retainAll(c2);
        } catch (Exception e) {
            System.out.println("retainAll(): " + e);
        }
        try {
            c.removeAll(c2);
        } catch (Exception e) {
            System.out.println("removeAll(): " + e);
        }

        try {
            c.clear();
        } catch (Exception e) {
            System.out.println("clear(): " + e);
        }
        try {
            c.add("X");
        } catch (Exception e) {
            System.out.println("add(): " + e);
        }
        try {
            c.addAll(c2);
        } catch (Exception e) {
            System.out.println("addAll(): " + e);
        }

        try {
            c.remove("C");
        } catch (Exception e) {
            System.out.println("remove(): " + e);
        }

        try {
            list.set(0, "X");
        } catch (Exception e) {
            System.out.println("list.set(): " + e);
        }
    }

    public static void main(String[] args) {
        /**
         * 使用Arrays.asList生成的list是不支持更改数组大小的操作的,但是可以修改里面的值
         */
        List<String> list = Arrays.asList("A B C D E F G H I J K L M N O P Q".split(" "));
        test("Modifiable Copy", new ArrayList<>(list));
        test("Arrays.asList()", list);
        /**
         * 使用Collections中的方法可以使该list不可变,包括修改元素的值和更改list的大小
         *         public E get(int index) {return list.get(index);}
         *         public E set(int index, E element) {
         *             throw new UnsupportedOperationException();
         *         }
         *         public void add(int index, E element) {
         *             throw new UnsupportedOperationException();
         *         }
         *         public E remove(int index) {
         *             throw new UnsupportedOperationException();
         *         }
         */
        test("unmodifiableList()", Collections.unmodifiableList(new ArrayList<>(list)));
    }
}
