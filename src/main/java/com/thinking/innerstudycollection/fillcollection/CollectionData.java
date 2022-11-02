package com.thinking.innerstudycollection.fillcollection;

import com.thinking.generic.Generator;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author 李昭
 * @Date 2020/6/22 22/03
 */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> generator, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(generator.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> generator, int quantity) {
        return new CollectionData<>(generator, quantity);
    }
}

/**
 * 适配器模式
 */
class Government implements Generator<String> {

    String[] foundation = "strange woman lying in ponds distributing swords is no basis for a system of government".split(" ");
    private int index;

    @Override
    public String next() {
        return foundation[index++];
    }
}

class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(new CollectionData<>(new Government(), 15));
        set.addAll(CollectionData.list(new Government(), 15));
        System.out.println(set);
    }
}