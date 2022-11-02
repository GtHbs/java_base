package com.thinking.io.file;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * 使用策略模式来处理文件
 *
 * @Author 李昭
 * @Date 2020/7/5 10/21
 */
public class ProcessFiles {
    public interface Strategy {
        /**
         * 策略接口实现方法
         */
        void process(File file);
    }

    private Strategy strategy;
    private String ext;
    private String regex;

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public ProcessFiles(Strategy strategy, String ext, String regex) {
        this.strategy = strategy;
        this.ext = ext;
        this.regex = regex;
    }


    public void start(String[] args) {
        try {
            if (args.length == 0) {
                processDirectoryTree(new File("."));
            } else {
                for (String arg : args) {
                    File file = new File(arg);
                    if (file.isDirectory()) {
                        processDirectoryTree(file);
                    } else {
                        Pattern pattern = Pattern.compile(regex);
                        if (!arg.endsWith("." + ext)) {
                            arg += "." + ext;
                        } else if (!pattern.matcher(arg).matches()) {
                            continue;
                        }
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理文件夹
     */
    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext).files) {
            strategy.process(file.getCanonicalFile());
        }
    }

    public static void main(String[] args) {
        new ProcessFiles(file -> System.out.println(file), "","*\\.java").start(args);
    }
}
