package com.project.world.hw;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * 重命名文件
 *
 * @author hwwei
 * @version 2025/5/25
 * @since 2025/5/25 23:17
 */
public class FileRename {

    public static void main(String[] args) {
        File targetDir = new File("F:\\美剧\\黑钱胜地");
        new FileRename().rename(targetDir);
    }

    public void rename(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null || files.length == 0) {
                return;
            }
            for (File listFile : files) {
                rename(listFile);
            }
        }

        String name = file.getName();
        if (name.endsWith(".mp41")) {
            String newName = name.substring(0, name.length() - 1);
            FileUtil.rename(file, newName, true);
        }
    }
}
