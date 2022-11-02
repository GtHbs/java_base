package com.thinking.containsobject;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: 李昭
 * @Date: 2020/6/8 7:56
 */
public class LinkedListFeatures {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(list);
        //getFirst()和element()方法相同,都返回第一个元素,如果链表为空,则抛出异常,而peek()方法则不一样,为空时返回null
        System.out.println("getFirst(): " + list.getFirst());
        System.out.println("element(): " + list.element());
        System.out.println("peek(): " + list.peek());
        //removeFirst()和remove()一样,链表为空时抛出异常,否则移除第一个元素,poll为空时返回null
        System.out.println("removeFirst(): " + list.removeFirst());
        System.out.println("poll(): " + list.poll());
        System.out.println(list);
        list.addFirst(10);
        System.out.println("after addFirst(): " + list);
        //offer()往链表后插入一条数据
        list.offer(5);
        System.out.println("After offer(): " + list);
        list.add(20);
        System.out.println("After add(): " + list);
        list.addLast(30);
        System.out.println("After addLast(): " + list);
        System.out.println("removeLast(): " + list.removeLast());
    }
}
