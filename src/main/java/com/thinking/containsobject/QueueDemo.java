package com.thinking.containsobject;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author: 李昭
 * @Date: 2020/6/9 20:06
 */
public class QueueDemo {

    public static void printQ(Queue queue) {
        while (queue.peek() != null) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            queue.offer(random.nextInt(i + 10));
        }
        printQ(queue);
        /**
         * 队列中方法:
         *  peek()方法会返回队头元素,如果队头元素为空,则返回null
         *  element() 方法返回队头元素,如果队头元素为空,抛出异常
         *  poll() 方法移除并返回队头,队列为空时返回null
         *  remove() 方法移除并返回队头,队列为空时抛出异常
         */
        Queue<Character> characterQueue = new LinkedList<>();
        for (char c : "刘国倩我想你!好后悔高中没有追你!".toCharArray()) {
            characterQueue.offer(c);
        }
        printQ(characterQueue);
    }
}
