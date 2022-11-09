package com.on_java.file;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/11/9 23:30
 */
public class PathWatcher {

    static Path test = Paths.get("test");

    static void delTxtFiles() {
        try {
            Files.walk(test).filter(f -> f.toString().endsWith(".txt")).forEach(f -> {
                try {
                    System.out.println("deleting: " + f);
                    Files.delete(f);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {

        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        Directories.refreshTestDir();
        Directories.populateTestDir();
        Files.createFile(test.resolve("hello.txt"));
        WatchService watchService = FileSystems.getDefault().newWatchService();
        test.register(watchService, ENTRY_DELETE);
        Executors.newSingleThreadScheduledExecutor().schedule(PathWatcher::delTxtFiles,250, TimeUnit.MILLISECONDS);
        WatchKey key = watchService.take();
        for (WatchEvent<?> event : key.pollEvents()) {
            System.out.println("context: " + event.context());
            System.out.println("count: " + event.count());
            System.out.println("kind: " + event.kind());
            System.exit(0);
        }
    }
}
