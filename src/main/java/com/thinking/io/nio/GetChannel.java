package com.thinking.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    private static final Integer BSIZE = 1024;
    private static final String FILE_NAME = "C:\\Users\\b\\Desktop\\a.txt";

    public static void main(String[] args) {
        try {
            FileChannel fileChannel = new FileOutputStream(FILE_NAME).getChannel();
            fileChannel.write(ByteBuffer.wrap("Hello World".getBytes()));
            fileChannel.close();
            fileChannel = new RandomAccessFile(FILE_NAME, "rw").getChannel();
            //定位到文件末尾
            fileChannel.position(fileChannel.size());
            fileChannel.write(ByteBuffer.wrap("programing".getBytes()));
            fileChannel = new FileInputStream(FILE_NAME).getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
            //从通道中读取的数据必须放在缓冲区中,否则无法读取
            fileChannel.read(buffer);
            //告诉缓冲区准备读取数据了
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ChannelCopy {
    private static final Integer BSIZE = 1024;
    private static final String a = "C:\\Users\\b\\Desktop\\a.txt";
    private static final String b = "C:\\Users\\b\\Desktop\\b.txt";

    public static void main(String[] args) throws Exception {
        FileChannel in = new FileInputStream(a).getChannel(), out = new FileOutputStream(b).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (in.read(buffer) != -1) {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }
}

class TransferTo {
    private static final String a = "C:\\Users\\b\\Desktop\\a.txt";
    private static final String b = "C:\\Users\\b\\Desktop\\b.txt";

    public static void main(String[] args) throws Exception {
        FileChannel in = new FileInputStream(a).getChannel(), out = new FileOutputStream(b).getChannel();
        in.transferTo(0, in.size(), out);
    }
}
