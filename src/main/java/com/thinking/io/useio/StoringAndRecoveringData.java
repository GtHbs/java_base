package com.thinking.io.useio;

import java.io.*;

/**
 * @Author 李昭
 * @Date 2020/7/7 07/56
 */
public class StoringAndRecoveringData {
    static String file = "C:\\Users\\李昭\\Desktop\\a.txt";
    public static void main(String[] args) throws Exception {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        out.writeDouble(Math.PI);
        out.writeUTF("That was pi");
        out.writeDouble(1.41);
        out.writeUTF("Square root of 2");
        out.close();
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
}
