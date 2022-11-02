package com.thinking.io.useio;

import java.io.StringReader;

/**
 * 内存输入
 *
 * @Author 李昭
 * @Date 2020/7/6 08/08
 */
public class MemoryInput {
    public static void main(String[] args) throws Exception {
        StringReader in = new StringReader(BufferedInputFile.read("C:\\Users\\李昭\\Desktop\\新建文本文档.txt"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.println((char) c);
        }
    }
}
