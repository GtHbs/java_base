package com.on_java.file;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/11/8 23:11
 */
public class PathInfo {


    static void info(Path path) {
        System.out.println("toStr:" + path);
        System.out.println("exist:" + Files.exists(path));
        System.out.println("regularFile: " + Files.isRegularFile(path));
        System.out.println("directory: " + Files.isDirectory(path)  );
        System.out.println("absolute: " + path.isAbsolute());
        System.out.println("filename: " + path.getFileName());
        System.out.println("parent: " + path.getParent());
        System.out.println("root: " + path.getRoot());
        System.out.println("*********************");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path path = Paths.get("PathInfo.java");
        info(path);
        Path absolutePath = path.toAbsolutePath();
        info(absolutePath);
        info(absolutePath.getParent());
        try {
            info(path.toRealPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        URI uri = path.toUri();
        System.out.println("uri: " + uri);
        Path uPath = Paths.get(uri);
        System.out.println(Files.exists(uPath));
        File file = absolutePath.toFile();
    }
}
