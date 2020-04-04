package com.project.world.algorithm;

import java.util.Stack;

public class RainBox {
    public int trap(int[] height) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int top = st.pop();
                if (st.empty()) {
                    break;
                }

                int distance = i - st.peek() - 1;
                int bounded_height = Math.min(height[i], height[st.peek()]) - height[top];
                ans += distance * bounded_height;
            }

            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = new RainBox().trap(height);
        System.out.println(trap);
    }
}
