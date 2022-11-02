package com.thinking.io.useio;

import java.io.RandomAccessFile;

/**
 * @Author 李昭
 * @Date 2020/7/7 08/07
 */
public class UsingRandomAccessFile {
    static String file = "C:\\Users\\李昭\\Desktop\\a.txt";

    static void display() throws Exception {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++) {
            System.out.println("Value: " + i + " : " + rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }


    public static void main(String[] args) throws Exception {
        /**
         * r: 只读
         * rw: 读写
         */
        RandomAccessFile rw = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++) {
            rw.writeDouble(i * 1.413);
        }
        rw.writeUTF("The end of the file");
        rw.close();
        display();
        rw = new RandomAccessFile(file,"rw");
        /**
         * 查找第五个双精度值
         */
        rw.seek(5 * 8);
        rw.writeDouble(47.0001);
        rw.close();
        display();
    }

}
