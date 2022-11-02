package com.thinking.io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Author 李昭
 * @Date 2020/7/5 09/10
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            /**
             * 策略模式,File.list()对该接口的实现了提供了方法,并且按照方法内的逻辑处理文件
             */
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dir : list) {
            System.out.println(dir);
        }
    }
}

class DirFilter implements FilenameFilter {

    private Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    /**
     * 该方法被用来过滤文件
     */
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}

/**
 * 重构上面的DirList,使用匿名内部类实现FilenameFilter
 */
class DirList2 {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            /**
             * 策略模式,File.list()对该接口的实现了提供了方法,并且按照方法内的逻辑处理文件
             */
            list = path.list(filter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        Long totalSize = 0L;
        for (String dir : list) {
            File file = new File(dir);
            totalSize += file.getUsableSpace();
            System.out.println(dir);
        }
        System.out.println(totalSize);
    }

    public static FilenameFilter filter(final String regex) {
        return (dir, name) -> {
            Pattern pattern = Pattern.compile(regex);
            return pattern.matcher(name).matches();
        };
    }
}

/**
 * 重构,使用lambda实现FilenameFilter
 */
class DirList3 {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            /**
             * 策略模式,File.list()对该接口的实现了提供了方法,并且按照方法内的逻辑处理文件
             */
            list = path.list(((dir, name) -> Pattern.compile(args[0]).matcher(name).matches()));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dir : list) {
            System.out.println(dir);
        }
    }
}

