package com.thinking.array.arrays;

import com.thinking.generic.Generator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * @Author 李昭
 * @Date 2020/6/21 13/00
 */
public class CompType implements Comparable<CompType> {
    int i;
    int j;
    private static int count = 1;

    public CompType(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        String result = "[i = " + i + ", j = " + j + "]";
        if (count++ % 3 == 0) {
            result += "\n";
        }
        return result;
    }

    @Override
    public int compareTo(CompType o) {
        return i < o.i ? -1 : (i == o.i ? 0 : 1);
    }

    private static Random random = new Random(47);

    public static Generator<CompType> generator() {
        return () -> new CompType(random.nextInt(100), random.nextInt(100));
    }

    public static void main(String[] args) {
        CompType[] types = {
          new CompType(22,13),
          new CompType(2,32),
          new CompType(21,2),
          new CompType(9,3),
          new CompType(4,31),
          new CompType(3,18),
          new CompType(24,7),
          new CompType(225,22),
          new CompType(122,89),
          new CompType(222,45),
          new CompType(8,0),
        };
        System.out.println("Before sorting");
        System.out.print(Arrays.toString(types));
        Arrays.sort(types);
        System.out.println("After sorting");
        System.out.print(Arrays.toString(types));
    }
}


class Reverse {
    public static void main(String[] args) {
        CompType[] types = {
                new CompType(22,13),
                new CompType(2,32),
                new CompType(21,2),
                new CompType(9,3),
                new CompType(4,31),
                new CompType(3,18),
                new CompType(24,7),
                new CompType(225,22),
                new CompType(122,89),
                new CompType(222,45),
                new CompType(8,0),
        };
        System.out.println("Before sorting");
        System.out.print(Arrays.toString(types));
        Arrays.sort(types, Collections.reverseOrder());
        System.out.println("After sorting");
        System.out.print(Arrays.toString(types));
    }
}

class CompTypeComparator implements Comparator<CompType> {

    @Override
    public int compare(CompType o1, CompType o2) {
        return o1.j < o2.j ? -1 : (o1.j == o2.j ? 0 : 1);
    }
}
class CompTypeComparatorTest {
    public static void main(String[] args) {
        CompType[] types = {
                new CompType(22,13),
                new CompType(2,32),
                new CompType(21,2),
                new CompType(9,3),
                new CompType(4,31),
                new CompType(3,18),
                new CompType(24,7),
                new CompType(225,22),
                new CompType(122,89),
                new CompType(222,45),
                new CompType(8,0),
        };
        System.out.println("Before sorting");
        System.out.print(Arrays.toString(types));
        Arrays.sort(types,new CompTypeComparator());
        System.out.println("After sorting");
        System.out.print(Arrays.toString(types));
    }
}