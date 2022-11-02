package com.thinking.innerstudycollection.queue;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 使用优先级队列
 *
 * @Author 李昭
 * @Date 2020/6/25 21/07
 */
public class TodoList extends PriorityQueue<TodoList.ToDoItem> {

    static class ToDoItem implements Comparable<ToDoItem> {
        private char primary;
        private int secondary;
        private String item;

        public ToDoItem(char primary, int secondary, String item) {
            this.primary = primary;
            this.secondary = secondary;
            this.item = item;
        }

        @Override
        public int compareTo(ToDoItem o) {
            if (primary > o.primary) {
                return +1;
            }
            if (primary == o.primary) {
                if (secondary > o.secondary) {
                    return +1;
                } else if (secondary == o.secondary) {
                    return 0;
                }
            }
            return -1;
        }

        @Override
        public String toString() {
            return Character.toString(primary) + secondary + " : " + item;
        }
    }

    public void add(String td, char pri, int sec) {
        super.add(new ToDoItem(pri, sec, td));
    }

    public static void main(String[] args) {
        TodoList list = new TodoList();
        list.add("Empty trash", 'C', 4);
        list.add("Feed dog", 'A', 2);
        list.add("Feed bird", 'B', 7);
        list.add("Mow lawn", 'C', 4);
        list.add("Water lawn", 'A', 1);
        list.add("Feed cat", 'B', 1);
        while (!list.isEmpty()) {
            System.out.println(list.remove());
        }
    }
}


class IntegerPriorityQueue extends PriorityQueue<IntegerPriorityQueue.IntegerComparable> {


    static class IntegerComparable implements Comparable<IntegerComparable> {
        private Integer item;

        public IntegerComparable(Integer item) {
            this.item = item;
        }

        @Override
        public int compareTo(IntegerComparable o) {
            if (item.equals(o.item)) {
                return 0;
            } else if (item < o.item) {
                return -1;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return item + " ";
        }
    }

    public void add(Integer item) {
        super.add(new IntegerComparable(item));
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        IntegerPriorityQueue queue = new IntegerPriorityQueue();
        queue.add(random.nextInt(100));
        queue.add(random.nextInt(100));
        queue.add(random.nextInt(100));
        queue.add(random.nextInt(100));
        queue.add(random.nextInt(100));
        queue.add(random.nextInt(100));
        queue.add(random.nextInt(100));
        queue.add(random.nextInt(100));
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
}