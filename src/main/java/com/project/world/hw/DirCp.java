package com.project.world.hw;

import cn.hutool.core.io.FileUtil;

import java.io.File;

public class DirCp {

    public static void main(String[] args) {
        File sourceDir = new File("D:\\Epic Project\\ActionRPG\\Content\\CharacterAssets\\InfinityBladeWeapons\\Weapons\\ForgingHammers");
        File targetDir = new File("D:\\Epic Project\\ActionRPG\\Content\\ActionRPGExt\\Pickups\\Weapons\\ForgingHammers");
        String absolutePath = targetDir.getAbsolutePath();

        File[] files = sourceDir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                String name = file.getName();
                FileUtil.mkdir(absolutePath+ "/" + name);
            }
        }

    }
}
