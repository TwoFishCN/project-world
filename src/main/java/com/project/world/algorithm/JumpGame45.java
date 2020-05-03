package com.project.world.algorithm;

public class JumpGame45 {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int step = 0;
        int currentIndex = 0;

        boolean notEnd = true;
        while (notEnd) {
            int numNow = nums[currentIndex];

            if (nums[currentIndex] + currentIndex >= nums.length - 1) {
                notEnd = false;
            } else {

                int maxWay = numNow + currentIndex;
                int nextStepIndex = currentIndex;

                for (int i = currentIndex + 1; i <= currentIndex + numNow; i++) {
                    int nextWay = i + nums[i];
                    if (nextWay > maxWay) {
                        maxWay = nextWay;
                        nextStepIndex = i;
                    }
                }
                currentIndex = nextStepIndex;
            }

            step++;
        }

        return step;
    }

    public static void main(String[] args) {
        int jump = new JumpGame45().jump(new int[]{1, 2});
        assert jump == 1;

        jump = new JumpGame45().jump(new int[]{0});
        assert jump == 0;

        jump = new JumpGame45().jump(new int[]{1});
        assert jump == 0;

        jump = new JumpGame45().jump(new int[]{2, 3, 1, 1, 4});
        assert jump == 2;
    }

}
