package com.thinking.io.useio;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

/**
 * 格式化内存输入
 *
 * @Author 李昭
 * @Date 2020/7/6 08/16
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws Exception {
        DataInputStream in = new DataInputStream(
                new ByteArrayInputStream(BufferedInputFile.read("C:\\Users\\李昭\\Desktop\\新建文本文档.txt").getBytes()));
        while (true) {
            System.out.println((char)in.readByte());
        }
    }
}
