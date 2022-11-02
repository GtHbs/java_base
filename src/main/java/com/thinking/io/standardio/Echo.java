package com.thinking.io.standardio;

import java.io.*;

/**
 * @Author 李昭
 * @Date 2020/7/8 08/09
 */
public class Echo {
    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\李昭\\Desktop\\1.txt";
        write(filename);
    }

    /**
     * 从标准输入中获取字符写入到文件中
     *
     * @param filename
     */
    public static void write(String filename) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new FileWriter(filename))) {
            String s;
            while ((s = in.readLine()) != null && s.length() != 0) {
                out.write(s);
                out.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = in.readLine()) != null && s.length() != 0) {
            System.out.println(s);
        }
    }
}
