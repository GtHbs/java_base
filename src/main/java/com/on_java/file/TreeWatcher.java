package com.on_java.file;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executors;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/11/9 23:40
 */
public class TreeWatcher {


    static void watchDir(Path dir) {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            dir.register(watchService, ENTRY_DELETE);
            Executors.newSingleThreadExecutor().submit(() -> {
                try {
                    WatchKey key = watchService.take();
                    for (WatchEvent<?> event : key.pollEvents()) {
                        System.out.println("context: " + event.context());
                        System.out.println("count: " + event.count());
                        System.out.println("kind: " + event.kind());
                        System.exit(0);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws IOException {
        Directories.refreshTestDir();
        Directories.populateTestDir();
        Files.walk(Paths.get("test")).filter(Files::isDirectory).forEach(TreeWatcher::watchDir);
        PathWatcher.delTxtFiles();
    }
}
