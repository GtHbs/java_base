package com.thinking.array.arrayandgeneric;

import com.thinking.array.arrayisspecial.BerylliumSphere;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 李昭
 * @Date 2020/6/21 10/00
 */
public class ArrayOfGeneric {
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = la;
        ls[0] = new ArrayList<>();
        Object[] objects = ls;
        objects[1] = new ArrayList<>();
        List<BerylliumSphere>[] spheres = new List[10];
        for (int i = 0; i < spheres.length; i++) {
            spheres[i] = new ArrayList<>();
        }
    }
}
