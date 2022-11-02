package com.thinking.innerstudycollection.usagemethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * 快速失败: 只能在获取迭代器之前对容器进行操作,否则会抛出异常,底层使用一个modCount维护操作次数,
 *          一旦在迭代过程中发现当前的modCount与之前的不同,就抛出异常
 *
 * @Author 李昭
 * @Date 2020/7/2 07/52
 */
public class FailFast {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        Iterator<String> it = c.iterator();
        c.add("object");
        try {
            String s = it.next();
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }
    }
}
