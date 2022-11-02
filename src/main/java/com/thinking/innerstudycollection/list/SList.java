package com.thinking.innerstudycollection.list;

/**
 * @Author 李昭
 * @Date 2020/6/24 21/25
 */
public class SList<T> {
    private static class Node<T> {
        T item;
        Node next;
    }


    /**
     * 链表头,用于遍历
     */
    private static Node tempFirst = new Node();
    /**
     * 链表尾,用于增删
     */
    private static Node first = tempFirst;

    private static class SListIterator<T> {

        private static Node t = tempFirst;

        public boolean hasNext() {
            return t != null;
        }

        public T next() {
            T s = (T) t.item;
            t = t.next;
            return s;
        }

        /**
         * 删除链表尾元素
         */
        public void remove() {
            Node temp = tempFirst;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            first = temp;
        }

        /**
         * 删除指定位置元素
         */
        public void remove(int index) {
            Node temp = tempFirst;
            while (index > 0 && temp.next != null) {
                index--;
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }

        /**
         * 删除具体元素
         */
        public void remove(T item) {
            Node temp = tempFirst;
            while (temp.next != null) {
                if (item.equals(temp.next.item)) {
                    break;
                }
                temp = temp.next;
            }
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }

        public void add(T item) {
            Node temp = new Node();
            temp.item = item;
            temp.next = null;
            first.next = temp;
            first = temp;
        }

        /**
         * 具体位置插入元素
         */
        public void add(int index, T item) {
            Node node = new Node();
            node.item = item;
            Node temp = tempFirst;
            while (index > 0 && temp.next != null) {
                index--;
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
    }

    public SListIterator<T> iterator() {
        return new SListIterator<>();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        SListIterator<T> iterator = iterator();
        iterator.next();
        while (iterator.hasNext()) {
            builder.append(iterator.next() + ",");
        }
        String s = builder.toString();
        s = s.substring(0, s.lastIndexOf(",")) + "]";
        return s;
    }

    public static void main(String[] args) {
        SList<String> list = new SList<>();
        SListIterator<String> iterator = (SList.SListIterator<String>) list.iterator();
        iterator.add("s");
        iterator.add("d");
        iterator.add("r");
        iterator.add("f");
        iterator.add("g");
        iterator.add("h");
        iterator.add(1,"x");
        String s = list.toString();
        System.out.println(s);
    }
}
