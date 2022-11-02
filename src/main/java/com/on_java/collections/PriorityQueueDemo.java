package com.on_java.collections;

import java.util.PriorityQueue;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/10/26 23:14
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<Priority> priorities = new PriorityQueue<>();
        Priority p1 = new Priority(1);
        Priority p2 = new Priority(2);
        Priority p3 = new Priority(3);
        priorities.add(p1);
        priorities.add(p2);
        priorities.add(p3);
        System.out.println(priorities.poll());
        System.out.println(priorities.poll());
        System.out.println(priorities.poll());
    }
}


class Priority implements Comparable<Priority> {


    private Integer id;

    public Priority(Integer id) {
        this.id = id;
    }

    @Override
    public int compareTo(Priority o) {
        return o.id - id;
    }

    @Override
    public String toString() {
        return "Priority{" +
                "id=" + id +
                '}';
    }
}