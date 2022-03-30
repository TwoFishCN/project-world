package com.project.world.algorithm;

import java.util.Arrays;

public class FindStartEndInSortArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3};
        int target = 1;

        int[] result = new FindStartEndInSortArray().searchRange(nums, target);
        System.out.println(Arrays.toString(result));
    }


    public int[] searchRange(int[] nums, int target) {
        int index = findIndex(nums, target);
        if (index == -1) {
            return new int[]{-1, -1};
        } else {
            int[] result = new int[]{index, index};
            while (result[0] > 0 && nums[result[0] - 1] == target) {
                result[0] = result[0] - 1;
            }

            final int maxIndex = nums.length - 1;
            while (result[1] < maxIndex && nums[result[1] + 1] == target) {
                result[1] = result[1] + 1;
            }
            return result;
        }
    }

    int findIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int index = (start + end) / 2;
            final int value = nums[index];
            if (value == target) {
                return index;
            } else if (value > target) {
                end = index - 1;
            } else {
                start = index + 1;
            }
        }

        return -1;
    }
}
