package com.project.world.lean.jdk;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.StandardWatchEventKinds.*;

public class WatchServiceDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("D:\\nodejs");
        WatchService watchService = FileSystems.getDefault().newWatchService();

        walkAndRegisterDirectories(path, watchService);

        System.out.println("Report any file changed within next 1 minutes...");

        while (true) {
            WatchKey watchKey = watchService.take();

            for (WatchEvent<?> event : watchKey.pollEvents()) {
                Path context = (Path) event.context();

                System.out.println(event.kind());
                System.out.println(context);
            }

            watchKey.reset();
        }
    }

    private static void walkAndRegisterDirectories(Path path, WatchService watchService) throws IOException {
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                dir.register(watchService, ENTRY_CREATE);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
