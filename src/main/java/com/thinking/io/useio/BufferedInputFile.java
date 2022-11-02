package com.thinking.io.useio;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author 李昭
 */
public class BufferedInputFile {
    public static String read(String filename) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = reader.readLine()) != null) {
            sb.append(s + "\n");
        }
        reader.close();
        return sb.toString();
    }
}