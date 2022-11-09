package com.on_java.file;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/11/8 23:19
 */
public class PartsOfPaths {

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path absolutePath = Paths.get("PartsOfPaths.java").toAbsolutePath();
        System.out.println(absolutePath);
        for (int i = 0; i < absolutePath.getNameCount(); i++) {
            System.out.println(absolutePath.getName(i));
        }
        System.out.println("ends with '.java': " + absolutePath.endsWith(".java"));
        for (Path path : absolutePath) {
            System.out.print(path + ":");
            System.out.print(absolutePath.startsWith(path) + " : ");
            System.out.println(absolutePath.endsWith(path));
        }
        System.out.println("starts with " + absolutePath.getRoot() + " " + absolutePath.startsWith(absolutePath.getRoot()));
    }
}
