package com.project.world.algorithm;

import java.util.Arrays;

public class HavePermutation {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        final HavePermutation havePermutation = new HavePermutation();
        boolean include = havePermutation.checkInclusion(s1, s2);
        System.out.println(include);

        s1 = "ab";
        s2 = "eidboaoo";
        include = havePermutation.checkInclusion(s1, s2);
        System.out.println(include);
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s2Hash = new int[26];
        int[] s2WindowHash = new int[26];

        final int windowSize = s1.length();

        for (int j = 0; j < windowSize; j++) {
            add(s2Hash, s1.charAt(j));
            add(s2WindowHash, s2.charAt(j));
        }

        for (int i = windowSize; i < s2.length(); i++) {
            if (Arrays.equals(s2Hash, s2WindowHash)) {
                return true;
            }

            sub(s2WindowHash, s2.charAt(i - windowSize));
            add(s2WindowHash, s2.charAt(i));
        }

        return Arrays.equals(s2Hash, s2WindowHash);
    }

    private void add(int[] map, char key) {
        final int index = key - 'a';
        map[index]++;
    }

    private void sub(int[] map, char key) {
        final int index = key - 'a';
        if (map[index] > 0) {
            map[index]--;
        }
    }
}
