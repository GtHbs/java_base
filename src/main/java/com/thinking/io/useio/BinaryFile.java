package com.thinking.io.useio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * @Author 李昭
 * @Date 2020/7/8 08/03
 */
public class BinaryFile {
    public static byte[] read(String filename) {
        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename))) {
            byte[] data = new byte[in.available()];
            in.read(data);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
