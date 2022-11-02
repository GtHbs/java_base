package com.thinking.generic;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @Author 李昭
 * @Date 2020/6/19 20/44
 */
public class ContainerMethodDifferences {
    /**
     * 获取该类的所有方法<br>
     */
    static Set<String> methodSets(Class<?> type) {
        Set<String> result = new TreeSet<>();
        for (Method method : type.getMethods()) {
            result.add(method.getName());
        }
        return result;
    }

    /**
     * 获取当前类实现的所有接口<br>
     */
    static void interfaces(Class<?> type) {
        System.out.print("Interfaces in " + type.getSimpleName());
        List<String> result = new ArrayList<>();
        for (Class<?> c : type.getInterfaces()) {
            result.add(c.getSimpleName());
        }
        System.out.println(result);
    }

    static Set<String> object = methodSets(Object.class);

    static {
        object.add("clone");
    }

    /**
     * 求两个类方法的差集<br>
     */
    static void difference(Class<?> superSet, Class<?> subSet) {
        System.out.print(superSet.getSimpleName() + " extends " + subSet.getSimpleName() + ", adds: ");
        Set<String> set = Sets.difference(methodSets(subSet), methodSets(subSet));
        set.removeAll(object);
        System.out.println(set);
        interfaces(superSet);
    }

    public static void main(String[] args) {
        System.out.println("Collection: " + methodSets(Collection.class));
        interfaces(Collection.class);
        difference(Set.class, Collection.class);
        difference(HashSet.class, Set.class);
        difference(LinkedHashMap.class, HashSet.class);
        difference(TreeSet.class, Set.class);
        difference(List.class, Collection.class);
        difference(ArrayList.class, List.class);
        difference(Queue.class, Collection.class);
        difference(PriorityQueue.class, Queue.class);
        difference(HashMap.class, Map.class);
        difference(LinkedHashMap.class, HashMap.class);
        difference(SortedMap.class, Map.class);
        difference(TreeMap.class, Map.class);
    }
}
