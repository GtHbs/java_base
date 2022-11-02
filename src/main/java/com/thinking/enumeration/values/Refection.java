package com.thinking.enumeration.values;

import com.thinking.io.processcontrol.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author 李昭
 * @Date 2020/7/13 07/56
 */
public class Refection {
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("------------ Analyzing " + enumClass + " --------------");
        System.out.println("Interfaces: ");
        for (Type t : enumClass.getGenericInterfaces()) {
            System.out.println(t);
        }
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("Methods: ");
        TreeSet<String> set = new TreeSet<>();
        for (Method m : enumClass.getMethods()) {
            set.add(m.getName());
        }
        System.out.println(set);
        return set;
    }

    public static void main(String[] args) {
        Set<String> explore = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("Explore.containsAll(Enum)? " + explore.containsAll(enumMethods));
        System.out.println("Explore.removeAll(Enum): ");
        explore.removeAll(enumMethods);
        OSExecute.command("javap Explore");
    }
}

/**
 * 枚举类型在编译过后会被定义为final类,
 * values和valueOf方法是编译时动态插入到类中的
 */
enum Explore {
    HERE, THERE
}
