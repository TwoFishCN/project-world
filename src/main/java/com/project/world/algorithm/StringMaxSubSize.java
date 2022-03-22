package com.project.world.algorithm;

public class StringMaxSubSize {

    public static void main(String[] args) {
        String str = "abcabcbb";
        int max = new StringMaxSubSize().lengthOfLongestSubstring(str);
        System.out.println(max);
    }

    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }

        int maxLen = Integer.MIN_VALUE;

        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            maxLen = Math.max(maxLen, i - start + 1);
            last[index] = i;
        }

        return maxLen;
    }
}
