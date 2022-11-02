package com.thinking.io.file;

import java.io.File;

/**
 * @Author 李昭
 * @Date 2020/7/5 10/11
 */
public class DirectoryDemo {
    public static void main(String[] args) {
        //获取所有的文件和目录
        PPrint.pprint(Directory.walk(".").dirs);
        for (File file : Directory.local(".","t.*")) {
            System.out.println(file);
        }
        System.out.println("-------------------------------");
        for (File file : Directory.walk(".","t.*\\.java")) {
            System.out.println(file);
        }
        System.out.println("================================");
        for (File file : Directory.walk(".",".*[Zz].*\\.class")) {
            System.out.println(file);
        }
    }
}
