package com.thinking.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
    private static final Integer BSIZE = 1024;
    private static final String a = "C:\\Users\\b\\Desktop\\a.txt";
    private static final String b = "C:\\Users\\b\\Desktop\\b.txt";

    public static void main(String[] args) {
        try {
            FileChannel fc = new FileOutputStream(a).getChannel();
            fc.write(ByteBuffer.wrap("aaa".getBytes()));
            fc.close();
            fc = new FileInputStream(a).getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
            fc.read(buffer);
            buffer.flip();
            System.out.println(buffer.asCharBuffer());
            //调用数据的开始部分
            buffer.rewind();
            //获取系统的编码格式
            String encoding = System.getProperty("file.encoding");
            System.out.println("Decoded using: " + encoding + " : " + Charset.forName(encoding).decode(buffer));
            fc = new FileOutputStream(b).getChannel();
            //写入时编码
            fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-8")));
            fc.close();
            fc = new FileInputStream(b).getChannel();
            buffer.clear();
            fc.read(buffer);
            buffer.flip();
            System.out.println(buffer.asCharBuffer());
            fc = new FileOutputStream(b).getChannel();
            buffer = ByteBuffer.allocate(24);
            //读出时编码
            buffer.asCharBuffer().put("Some text");
            fc.write(buffer);
            fc.close();
            fc = new FileInputStream(b).getChannel();
            buffer.clear();
            fc.read(buffer);
            buffer.flip();
            System.out.println(buffer.asCharBuffer());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
