package com.on_java.file;

import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/11/9 23:09
 */
public class Directories {


    static Path test = Paths.get("test");
    static String sep = FileSystems.getDefault().getSeparator();
    static List<String> parts = Arrays.asList("foo", "bar", "baz", "bag");

    static Path makeVariant() {
        Collections.rotate(parts, 1);
        return Paths.get("test", String.join(sep, parts));
    }


    static void refreshTestDir() throws IOException {
        if (Files.exists(test)) {
            RmDir.rmDir(test);
        } else {
            Files.createDirectory(test);
        }
    }


    static void populateTestDir() throws IOException {
        for (int i = 0; i < parts.size(); i++) {
            Path variant = makeVariant();
            if (!Files.exists(variant)) {
                Files.createDirectories(variant);
                Files.copy(Paths.get("F:\\program\\mine\\java\\ThinkingJava\\src\\main\\java\\com\\on_java\\file\\Directories.java"), variant.resolve("File.txt"));
                Files.createTempFile(variant, null, null);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        refreshTestDir();
        Files.createFile(test.resolve("hello.txt"));
        Path variant = makeVariant();
        try {
            Files.createDirectory(variant);
        } catch (Exception e) {

        }
        populateTestDir();
        Path tempDir = Files.createTempDirectory(test, "DIR_");
        Files.createTempFile(tempDir, "pre", ".non");
        Files.newDirectoryStream(test).forEach(System.out::println);
        System.out.println("****************************");
        Files.walk(test).forEach(System.out::println);
    }
}
