package com.thinking.innerstudycollection.usagemethod;

import java.util.*;

/**
 * 使用Collections使容器同步,实现原理为给每个容器加上一把锁(默认给一个对象锁),
 * 不推荐使用,效率太低
 *
 * @Author 李昭
 * @Date 2020/7/2 07/49
 */
public class Synchronization {
    public static void main(String[] args) {
        Collection<String> c = Collections.synchronizedCollection(new ArrayList<>());
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Set<String> set = Collections.synchronizedSet(new HashSet<>());
    }
}
