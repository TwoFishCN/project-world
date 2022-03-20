package com.project.world.algorithm;

import java.util.Arrays;

public class MoveZero {
    public static void main(String[] args) {
        int[]  nums = new int[]{0,1,0,3,12};
        new MoveZero().moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        if(nums==null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for(int i=0;i<nums.length;++i) {
            if(nums[i]!=0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for(int i=j;i<nums.length;++i) {
            nums[i] = 0;
        }
    }
}
