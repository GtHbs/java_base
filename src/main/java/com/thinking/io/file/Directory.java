package com.thinking.io.file;

import java.io.File;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @Author 李昭
 * @Date 2020/7/5 09/44
 */
public final class Directory {
    /**
     * 该方法用来获取dir路径下的所有文件构成的对象数组<br>
     * 参数:<br>
     * 1, dir File 文件路径<br>
     * 2, regex String 用于匹配的正则表达式<br>
     */
    public static File[] local(File dir, final String regex) {
        return dir.listFiles(((dir1, name) -> Pattern.compile(regex).matcher(name).matches()));
    }

    /**
     * 上面的重载方法
     */
    public static File[] local(String path, String regex) {
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {

        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();


        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) + "\n\nfiles: " + PPrint.pformat(files);
        }
    }

    public static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start), regex);
    }

    public static TreeInfo walk(File start, String regex) {
        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }

    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo info = new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()) {
                info.dirs.add(item);
                info.addAll(recurseDirs(item, regex));
            } else {
                if (item.getName().matches(regex)) {
                    info.files.add(item);
                }
            }
        }
        return info;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(walk("."));
        } else {
            for (String arg : args) {
                System.out.println(walk(arg));
            }
        }
    }
}


class PPrint {
    public static String pformat(Collection<?> c) {
        if (c.size() == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (Object elem : c) {
            if (c.size() != 1) {
                builder.append("\n ");
            }
            builder.append(elem);
        }
        if (c.size() != 1) {
            builder.append("\n");
        }
        builder.append("]");
        return builder.toString();
    }

    public static void pprint(Collection<?> c) {
        System.out.println(pformat(c));
    }

    public static void pprint(Object[] c) {
        System.out.println(pformat(Arrays.asList(c)));
    }
}