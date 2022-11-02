package com.thinking.io.standardio;

import com.thinking.io.processcontrol.OSExecute;

import java.io.*;

/**
 * @Author 李昭
 * @Date 2020/7/8 08/19
 */
public class Redirecting {
    public static void main(String[] args) {
        String filename = "C:\\Users\\李昭\\Desktop\\1.txt";
        String filename2 = "C:\\Users\\李昭\\Desktop\\2.txt";
        PrintStream console = System.out;
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename));
            PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(filename2)));
            System.setIn(in);
            System.setOut(out);
            System.setErr(out);
            //这一步输入被重定向到文件1
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s;
            while ((s = br.readLine()) != null) {
                //这一步被重定向到了文件,并不是控制台
                System.out.println(s);
            }
            out.close();
            System.setOut(console);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class OSExecuteDemo {
    public static void main(String[] args) {
        OSExecute.command("javap OSExecuteDemo");
    }
}
