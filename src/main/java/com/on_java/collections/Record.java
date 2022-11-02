package com.on_java.collections;


import java.util.Map;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/10/26 23:10
 */
public class Record {

    public static void main(String[] args) {
        var a = new Employee("A", 1);
        var b = new Employee("B", 2);
        System.out.println(a.name());
        System.out.println(a.id());
        var map = Map.of(a, "C", b, "D");
        System.out.println(map);
    }
}

record Employee(String name, int id) {
}

