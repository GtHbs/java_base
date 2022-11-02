package com.thinking.array.arrays;

import com.thinking.array.arrayisspecial.BerylliumSphere;

import java.util.Arrays;

/**
 * @Author 李昭
 * @Date 2020/6/21 11/21
 */
public class CopyingArrays {
    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[7];
        Arrays.fill(i, 47);
        Arrays.fill(j, 99);
        System.out.println("i = " + Arrays.toString(i));
        System.out.println("j = " + Arrays.toString(j));
        System.arraycopy(i, 0, j, 0, i.length);
        System.out.println("j = " + Arrays.toString(j));
        Integer[] u = new Integer[10];
        Integer[] v = new Integer[5];
        Arrays.fill(u, new Integer(47));
        Arrays.fill(v, 10);
        System.out.println("u = " + Arrays.toString(u));
        System.out.println("v = " + Arrays.toString(v));
        System.arraycopy(v, 0, u, 0, v.length);
        System.out.println("u = " + Arrays.toString(u));
        BerylliumSphere[] spheres = new BerylliumSphere[5];
        BerylliumSphere[] berylliumSpheres = new BerylliumSphere[10];
        Arrays.fill(spheres, new BerylliumSphere());
        for (BerylliumSphere sphere : spheres) {
            System.out.print(sphere + " ");
        }
        System.out.println();
        //使用这种方式拷贝数组为浅拷贝,基本类型直接复制值,对象类型复制引用
        System.arraycopy(spheres, 0, berylliumSpheres, 0, spheres.length);
        for (BerylliumSphere sphere : berylliumSpheres) {
            System.out.print(sphere + " ");
        }
    }
}
