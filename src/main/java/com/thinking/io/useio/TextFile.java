package com.thinking.io.useio;

import java.io.*;
import java.util.*;

/**
 * @Author 李昭
 * @Date 2020/7/8 07/24
 */
public class TextFile extends ArrayList<String> {

    public static String read(String filename) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(filename).getAbsolutePath()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void write(String filename, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(filename).getAbsolutePath());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public TextFile(String filename, String splitter) {
        super(Arrays.asList(read(filename).split(splitter)));
        if (get(0).equals(" ")) {
            remove(0);
        }
    }

    public TextFile(String filename) {
        this(filename, "\n");
    }

    public void write(String filename) {
        try (PrintWriter out = new PrintWriter(new File(filename).getAbsolutePath())) {
            for (String item : this) {
                out.println(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "C:\\Users\\李昭\\Desktop\\1.txt";
        String filename2 = "C:\\Users\\李昭\\Desktop\\2.txt";
        String file = read(filename);
        write(filename2, file);
        TextFile text = new TextFile(filename2);
        text.write(filename2);
        TreeSet<String> words = new TreeSet<>(new TextFile(filename, "\\w+"));
        System.out.println(words.headSet("a"));
    }
}

class TextFile2 {

    private static Map<String, Integer> map = new HashMap<>();

    public static String read(String filename) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String s;
            while ((s = in.readLine()) != null) {
                String[] split = s.split("");
                for (String c : split) {
                    if (map.containsKey(c)) {
                        Integer integer = map.get(c);
                        map.put(c, integer + 1);
                    } else {
                        map.put(c, 1);
                    }
                }
                builder.append(s);
                builder.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
    public static Integer readCount(String filename,String c) {
        read(filename);
        return map.get(c);
    }

    public static void main(String[] args) {
        String filename = "C:\\Users\\李昭\\Desktop\\1.txt";
        Integer a = readCount(filename, "a");
        System.out.println(a);
    }
}
