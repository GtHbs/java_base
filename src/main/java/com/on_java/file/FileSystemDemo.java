package com.on_java.file;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/11/9 23:28
 */
public class FileSystemDemo {

    public static void main(String[] args) {
        FileSystem system = FileSystems.getDefault();
        for (FileStore fileStore : system.getFileStores()) {
            System.out.println(fileStore);
        }
        Iterable<Path> directories = system.getRootDirectories();
        for (Path directory : directories) {
            System.out.println(directory);
        }
        System.out.println(system.getUserPrincipalLookupService());
        System.out.println(system.isOpen());
        System.out.println(system.isReadOnly());
        System.out.println(system.provider());
        System.out.println(system.supportedFileAttributeViews());
    }
}
