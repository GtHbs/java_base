package com.thinking.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author 李昭
 * @Date 2020/6/14 21/22
 */
public class InputFile {
    private BufferedReader in;

    public InputFile(String name) throws FileNotFoundException {
        try {
            in = new BufferedReader(new FileReader(name));
        } catch (FileNotFoundException e) {
            System.out.println("Could not open " + name);
            throw e;
        } catch (Exception e) {
            try {
                in.close();
            } catch (IOException ex) {
                System.out.println("in.close() unsuccessful");
            }
            throw e;
        } finally {
            //Don`t close it here,because initialized object should survive in all lifecycle
        }
    }

    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }

    public void dispose() {
        try {
            in.close();
        } catch (IOException e) {
            throw new RuntimeException("in.close() failed");
        }
    }
}

class Cleanup {
    public static void main(String[] args) {
        try {
            //在创建对象时就抛出了异常,所以下面的try块不会执行
            InputFile in = new InputFile("Cleanup.java");
            try {
                String s;
                int i = 1;
                while ((s = in.getLine()) != null) ;
            } catch (Exception e) {
                System.out.println("Caught Exception in main");
                e.printStackTrace(System.out);
            } finally {
                in.dispose();
            }
        } catch (Exception e) {
            System.out.println("InputFile construction failed");
        }
    }
}