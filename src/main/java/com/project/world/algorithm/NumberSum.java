package com.project.world.algorithm;

import java.util.HashMap;
import java.util.Map;

public class NumberSum {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;

    }

    public int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int number = target - nums[i];

            if (map.containsKey(number)) {
                return new int[]{map.get(number), i};
            }

            map.put(nums[i], i);
        }

        return null;

    }

    public static void main(String[] args) {
        int[] ints = new NumberSum().twoSum2(new int[]{3,2,4}, 6);
        System.out.println(ints[0] + ", " + ints[1]);
    }
}
