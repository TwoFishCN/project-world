package com.project.world.algorithm;

import java.util.Stack;

public class StringIsEq {

    public static void main(String[] args) {
        String s = "y#fo##f", t = "y#f#o##f";
        final boolean b = new StringIsEq().backspaceCompare(s, t);
        System.out.println(b);
    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = simple(s);
        Stack<Character> stackT = simple(t);
        return stackS.equals(stackT);
    }

    public Stack<Character> simple(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c == '#') {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack;
    }
}
