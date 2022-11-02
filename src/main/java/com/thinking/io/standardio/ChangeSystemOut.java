package com.thinking.io.standardio;

import java.io.PrintWriter;

/**
 * @Author 李昭
 * @Date 2020/7/8 08/16
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        //将System.out转换为PrintWriter,原来是PrintStream,底层使用OutputStreamWriter转换
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello,World");
    }
}
