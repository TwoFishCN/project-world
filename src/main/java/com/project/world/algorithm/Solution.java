package com.project.world.algorithm;
/*
* 
* */
class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charsSubtitleVector = buildSubtitleVector(chars);

        int res = 0;
        for (String word : words) {
            int[] wordSubtitleVector = buildSubtitleVector(word);
            if (isMastered(wordSubtitleVector, charsSubtitleVector)) {
                res += word.length();
            }
        }
        return res;
    }

    public int[] buildSubtitleVector(String chars) {
        int[] charsSubtitleVector = new int[26];
        chars.chars().forEach(it -> charsSubtitleVector[it - 'a'] += 1);
        return charsSubtitleVector;
    }

    private boolean isMastered(int[] wordSubtitleVector, int[] charsSubtitleVector) {
        for (int i = 0; i < 26; i++) {
            if (wordSubtitleVector[i] > charsSubtitleVector[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int v2 = new Solution().countCharacters(new String[]{"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin", "ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb", "ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl", "boygirdlggnh", "xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx", "nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop", "hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx", "juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr", "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo", "oxgaskztzroxuntiwlfyufddl", "tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp", "qnagrpfzlyrouolqquytwnwnsqnmuzphne", "eeilfdaookieawrrbvtnqfzcricvhpiv", "sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz", "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue", "hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv", "cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo", "teyygdmmyadppuopvqdodaczob", "qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs", "qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"}, "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp");
        System.out.println(v2);
    }
}
