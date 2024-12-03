package com.project.world.hw;

import java.util.HashMap;

// 两数之和问题 https://www.nowcoder.com/practice/20ef0972485e41019e39543e8e895b7f?tpId=196&tqId=37090&ru=/exam/oj
public class TwoNumberSUm {
    public int[] twoSumN(int[] numbers, int target) {
        // write code here
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }

    public int[] twoSum(int[] numbers, int target) {
        // value -> index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(i) + 1, i + 1};
            } else {
                map.put(numbers[i], i);
            }
        }
        return null;
    }
}
