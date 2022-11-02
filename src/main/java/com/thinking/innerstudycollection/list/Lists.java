package com.thinking.innerstudycollection.list;

import com.thinking.innerstudycollection.fillcollection.Countries;
import org.junit.Test;

import java.util.*;

/**
 * @Author 李昭
 * @Date 2020/6/24 20/55
 */
public class Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;

    public static void basicTest(List<String> a) {
        //在指定的位置插入元素
        a.add(1, "x");
        //在末尾插入元素
        a.add("x");
        a.addAll(Countries.names(25));
        //从下标为3的位置开始插入
        a.addAll(3, Countries.names(25));
        b = a.contains("1");
        b = a.containsAll(Countries.names(25));
        s = a.get(1);
        i = a.indexOf("1");
        b = a.isEmpty();
        it = a.iterator();
        lit = a.listIterator();
        //从下标为3的位置开始遍历
        lit = a.listIterator(3);
        i = a.lastIndexOf("1");
        //删除位置为1的元素
        a.remove(1);
        a.remove("1");
        a.set(1, "y");
        //只保留所选元素
        a.retainAll(Countries.names(25));
        a.retainAll(Countries.names(25));
        i = a.size();
        a.clear();
    }

    public static void iterMotion(List<String> a) {
        ListIterator<String> it = a.listIterator();
        b = it.hasNext();
        b = it.hasPrevious();
        s = it.next();
        i = it.nextIndex();
        s = it.previous();
        i = it.previousIndex();
    }

    /**
     * 在迭代的过程中操作
     */
    public static void iterManipulation(List<String> a) {
        ListIterator<String> it = a.listIterator();
        it.add("47");
        it.next();
        it.remove();
        it.next();
        it.set("47");
    }

    public static void testVisual(List<String> a) {
        System.out.println(a);
        List<String> b = Countries.names(25);
        System.out.println("b = " + b);
        a.addAll(b);
        a.addAll(b);
        System.out.println(a);
        //从一半的地方开始遍历
        ListIterator<String> x = a.listIterator(a.size() / 2);
        x.add("one");
        System.out.println(a);
        System.out.println(x.next());
        x.remove();
        System.out.println(x.next());
        x.set("47");
        System.out.println(a);
        x = a.listIterator(a.size());
        while (x.hasPrevious()) {
            System.out.print(x.previousIndex() + " ");
        }
        System.out.println();
        System.out.println("testVisual finished");
    }

    public static void testLinkedList() {
        LinkedList<String> ll = new LinkedList<>();
        ll.addAll(Countries.names(25));
        System.out.println(ll);
        ll.addFirst("one");
        ll.addFirst("two");
        System.out.println(ll);
        System.out.println(ll.getFirst());
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeLast());
        System.out.println(ll);
    }

    public static void main(String[] args) {
        basicTest(new LinkedList<>(Countries.names(25)));
        basicTest(new ArrayList<>(Countries.names(25)));
        iterMotion(new ArrayList<>(Countries.names(25)));
        iterMotion(new LinkedList<>(Countries.names(25)));
        iterManipulation(new ArrayList<>(Countries.names(25)));
        iterManipulation(new LinkedList<>(Countries.names(25)));
        testLinkedList();
    }

    @Test
    public void test() {
        List<String> al = new ArrayList<>(Countries.names(25));
        List<String> ll = new LinkedList<>(Countries.names(25));
        Iterator<String> alIt = al.iterator();
        Iterator<String> llIt = ll.iterator();
        while (alIt.hasNext()) {
            System.out.print(alIt.next() + " ");
        }
        System.out.println();
        while (llIt.hasNext()) {
            System.out.print(llIt.next() + " ");
        }
        System.out.println();
        ListIterator<String> alLit = al.listIterator();
        llIt = ll.iterator();
        while (alLit.hasPrevious() && llIt.hasNext()) {
            alLit.previous();
            alLit.add(llIt.next());
        }
        System.out.println(al);
    }
}
