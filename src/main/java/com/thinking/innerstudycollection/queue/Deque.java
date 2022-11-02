package com.thinking.innerstudycollection.queue;

import java.util.LinkedList;

/**
 * 实现双向队列
 *
 * @Author 李昭
 * @Date 2020/6/25 21/29
 */
public class Deque<T> {
    private LinkedList<T> deque = new LinkedList<>();

    public void addFirst(T e) {
        deque.addFirst(e);
    }

    public void addLast(T e) {
        deque.addLast(e);
    }

    public T getFirst() {
        return deque.getFirst();
    }

    public T getLast() {
        return deque.getLast();
    }

    public T removeFirst() {
        return deque.removeFirst();
    }

    public T removeLast() {
        return deque.removeLast();
    }

    public int size() {
        return deque.size();
    }

    @Override
    public String toString() {
        return deque.toString();
    }
}

class DequeTest {
    static void fillTest(Deque<Integer> deque) {
        for (int i = 20; i < 27; i++) {
            deque.addFirst(i);
        }
        for (int i = 50; i < 55; i++) {
            deque.addLast(i);
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        fillTest(deque);
        while (deque.size() != 0) {
            System.out.print(deque.removeFirst() + " ");
        }
        System.out.println();
        fillTest(deque);
        while (deque.size() != 0) {
            System.out.print(deque.removeLast() + " ");
        }
    }
}
