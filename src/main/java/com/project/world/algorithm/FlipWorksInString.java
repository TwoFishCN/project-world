package com.project.world.algorithm;

public class FlipWorksInString {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String b = new FlipWorksInString().reverseWords(s);
        System.out.println(b);
        System.out.println(b.equals("s'teL ekat edoCteeL tsetnoc"));
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();

        int wordLeft = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                this.reverseWord(chars, wordLeft, i - 1);
                wordLeft = i + 1;
            }
        }
        if (wordLeft < chars.length) {
            this.reverseWord(chars, wordLeft, chars.length - 1);
        }

        return new String(chars);
    }

    public void reverseWord(char[] chars, int wordLeft, int wordRight) {
        char tmp;

        int left = wordLeft;
        int right = wordRight;
        while (left < right) {
            tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;

            left++;
            right--;
        }
    }
}
