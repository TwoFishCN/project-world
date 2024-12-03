package com.project.world.hw;

import java.util.Scanner;

// 16 进制字符串转换10进制输出

public class ToTen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            System.out.println(Integer.parseInt(s.substring(2),16));
            // 1.9 以后的JDK可以写成
            System.out.println(Integer.parseInt(s,2,s.length(),16));
        }
    }
}
