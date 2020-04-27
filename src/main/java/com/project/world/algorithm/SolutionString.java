package com.project.world.algorithm;

import java.util.Stack;

class SolutionString {
    public boolean isValid(String s) {
        Stack<Integer> stack = new Stack<>();

        /*空串为真*/
        if (s.isEmpty()) {
            return true;
        }

        char[] chars = s.toCharArray();

        for (int it : chars) {
            if (isLeftBrackets(it)) {
                stack.add(it);
            } else {
                if (stack.isEmpty()){
                    return false;
                }

                if (!isPair(stack.pop(), it)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isPair(int poll, int it) {
        if (poll == '(') {
            return it == ')';
        } else if (poll == '[') {
            return it == ']';
        } else if (poll == '{') {
            return it == '}';
        }
        return false;
    }

    public boolean isLeftBrackets(int it) {
        return it == '(' || it == '[' || it == '{';
    }

    public static void main(String[] args) {
        SolutionString solutionString = new SolutionString();
        assert !solutionString.isValid("{}{}[]()[");
        assert !solutionString.isValid("([)]");
    }

}