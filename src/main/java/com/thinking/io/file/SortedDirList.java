package com.thinking.io.file;

import java.io.File;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Author 李昭
 * @Date 2020/7/5 09/33
 */
public class SortedDirList {
    private String path;

    public SortedDirList(String path) {
        this.path = path;
    }

    /**
     * 按照正则表达式过滤文件
     */
    public void list(String regex) {
        File file = new File(path);
        String[] list = file.list(((dir, name) -> Pattern.compile(regex).matcher(name).matches()));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        Arrays.stream(list).forEach(System.out::println);
    }

    /**
     * 获取目标路径下的文件和文件夹并且打印其名
     */
    public void list() {
        File file = new File(path);
        String[] list = file.list();
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        Arrays.stream(list).forEach(System.out::println);
    }

    public static void main(String[] args) {
        SortedDirList list = new SortedDirList("E:\\program\\java\\ThinkingJava\\src\\main\\java\\com.thinking.io\\file");
        list.list();
    }
}
