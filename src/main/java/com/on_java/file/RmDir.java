package com.on_java.file;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/11/9 23:02
 */
public class RmDir {


    /**
     * 删除目录和文件
     * @param dir
     * @throws IOException
     */
    public static void rmDir(Path dir) throws IOException {
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            /**
             * 在当前目录的每个文件上运行
             * @param file
             *          a reference to the file
             * @param attrs
             *          the file's basic attributes
             *
             * @return
             * @throws IOException
             */
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            /**
             * 先进入当前目录下的我文件和目录
             * @param dir
             *          a reference to the directory
             * @param exc
             *          {@code null} if the iteration of the directory completes without
             *          an error; otherwise the I/O exception that caused the iteration
             *          of the directory to complete prematurely
             *
             * @return
             * @throws IOException
             */
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });

    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\15840\\Desktop\\test");
        rmDir(path);
    }
}
