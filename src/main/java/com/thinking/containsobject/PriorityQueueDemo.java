package com.thinking.containsobject;

import org.junit.Test;

import java.util.*;

/**
 * @author: 李昭
 * @Date: 2020/6/9 20:24
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            /**
             * 数字型默认排序是从小到大排序
             */
            queue.offer(random.nextInt(i + 10));
        }
        QueueDemo.printQ(queue);
        List<Integer> list = Arrays.asList(25, 267, 1, 2, 3, 3, 389, 23, 12, 34, 32, 42);
        queue = new PriorityQueue<>(list);
        QueueDemo.printQ(queue);
        queue = new PriorityQueue<>(list.size(), Collections.reverseOrder());
        queue.addAll(list);
        System.out.println("--------------------------------------------------");
        /**
         * 对于字符型,默认排序是按照字典排序
         */
        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPriorityQueue = new PriorityQueue<>(strings);
        QueueDemo.printQ(stringPriorityQueue);
        stringPriorityQueue = new PriorityQueue<>(strings.size(), Collections.reverseOrder());
        stringPriorityQueue.addAll(strings);
        QueueDemo.printQ(stringPriorityQueue);
        System.out.println("---------------------------------------------------");
        Set<Character> set = new HashSet<>();
        for (char c : fact.toCharArray()) {
            set.add(c);
        }
        PriorityQueue<Character> characters = new PriorityQueue<>(set);
        QueueDemo.printQ(characters);
    }

    @Test
    public void test() {
        PriorityQueue<Fruit> queue = new PriorityQueue<>(new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                if (o1.getName().equals(o2.getName())) {
                    return o1.getColor().compareTo(o2.getColor());
                }
                return (int) (o1.getWeight() - o2.getWeight());
            }
        });
        queue.offer(new Fruit("Apple","red",22.2));
        queue.offer(new Fruit("Strawberry","red",32.2));
        queue.offer(new Fruit("Orange","yellow",12.2));
        queue.offer(new Fruit("Cucumber","green",92.2));
        queue.offer(new Fruit("Tomato","red",2.2));

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
