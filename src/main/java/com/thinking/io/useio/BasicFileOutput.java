package com.thinking.io.useio;

import java.io.*;

/**
 * @Author 李昭
 * @Date 2020/7/7 07/17
 */
public class BasicFileOutput {
    static final String path = "E:\\program\\java\\ThinkingJava\\src\\main\\java\\com.thinking.io\\useio\\BufferedInputFile.java";

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(path)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + " : " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(path));
    }
}
