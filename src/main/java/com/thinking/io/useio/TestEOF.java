package com.thinking.io.useio;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * @Author 李昭
 * @Date 2020/7/7 07/13
 */
public class TestEOF {
    public static void main(String[] args) throws Exception {
        DataInputStream stream = new DataInputStream(new BufferedInputStream(new FileInputStream("TestEOF.java")));
        while (stream.available() != 0) {
            System.out.println((char)stream.readByte());
        }
    }
}
