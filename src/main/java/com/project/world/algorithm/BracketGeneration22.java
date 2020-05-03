package com.project.world.algorithm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BracketGeneration22 {

    ArrayList[] cache = new ArrayList[100];

    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generate(c))
                    for (String right: generate(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        cache[n] = ans;
        return ans;
    }

    public List<String> generateParenthesis(int n) {
        return generate(n);
    }


    public static void main(String[] args) {

        System.out.println(Calendar.getInstance().getTime());
        List<String> strings = new BracketGeneration22().generateParenthesis(16);
        System.out.println(Calendar.getInstance().getTime());
    }
}
