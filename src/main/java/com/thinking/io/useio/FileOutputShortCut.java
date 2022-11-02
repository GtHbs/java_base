package com.thinking.io.useio;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @Author 李昭
 * @Date 2020/7/7 07/47
 */
public class FileOutputShortCut {
    static String file = "C:\\Users\\李昭\\Desktop\\a.txt";

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("E:\\program\\java\\ThinkingJava\\src\\main\\java\\com.thinking.io\\useio\\MemoryInput.java")));
        PrintWriter writer = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            writer.println(lineCount++ + " : " + s);
        }
        writer.close();
        System.out.println(BufferedInputFile.read(file));

    }
}
