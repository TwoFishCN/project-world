package com.project.world.hw;

import java.util.Scanner;

/*
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
一个长整数。
举例：一个ip地址为10.0.3.193
每段数字             相对应的二进制数
10                   00001010
0                    00000000
3                    00000011
193                  11000001

组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。

数据范围：保证输入的是合法的 IP 序列
 */
public class JumpA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String data = in.nextLine();
            if (data.contains(".")) {
                System.out.println(toTenNumber(data));
            } else {
                System.out.println(toIpString(data));
            }
        }
    }

    private static String toIpString(String data) {
        String binaryString = Long.toBinaryString(Long.parseLong(data));
        int size = binaryString.length();
        return String.valueOf(Long.parseLong(binaryString.substring(0, size - 24), 2)) + "." +
                Long.parseLong(binaryString.substring(size - 24, size - 16), 2) + "." +
                Long.parseLong(binaryString.substring(size - 16, size - 8), 2) + "." +
                Long.parseLong(binaryString.substring(size - 8, size), 2);
    }

    private static long toTenNumber(String data) {
        String[] ipNum = data.split("\\.");

        StringBuilder values = new StringBuilder();
        for (String s : ipNum) {
            String binaryString = Long.toBinaryString(Long.parseLong(s));
            if (binaryString.length() < 8) {
                for (int i = 0; i < 8 - binaryString.length(); i++) {
                    values.append('0');
                }
            }
            values.append(binaryString);
        }
        return Long.parseLong(values.toString(), 2);
    }


}
