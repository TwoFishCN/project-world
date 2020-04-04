package com.project.world.algorithm;

public class MaxString {

    public String lastSubstring(String s) {

        char max = (char) Integer.MIN_VALUE;
        int maxIndex = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar > max) {
                max = aChar;
                maxIndex = i;
            } else if (aChar == max) {

//                从别人的题解中看到的秘之操作，wtf 这是要做什么，但是确实减少了很多不必要的计算（毫无道理但是通过了）
                if (chars[i] == chars[i - 1]) continue;

                int range = Math.min(chars.length - i, i - maxIndex);

                for (int j = 1; j < range; j++) {
                    if (chars[i + j] > chars[maxIndex + j]) {
                        max = aChar;
                        maxIndex = i;
                    } else if (chars[i + j] < chars[maxIndex + j]) {
                        break;
                    }
                }
            }
        }

        return s.substring(maxIndex);
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 200000; i++) {
            builder.append('a');
        }

        String cacacb = new MaxString().lastSubstring(builder.toString());
        System.out.println(cacacb.length());
    }
}
