package com.project.world.algorithm;

import java.util.Arrays;

public class FlipString {

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        new FlipString().reverseString(s);

        System.out.println(Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        char tmp;

        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            left++;
            right--;
        }
    }
}
