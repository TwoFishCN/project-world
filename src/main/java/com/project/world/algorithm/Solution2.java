package com.project.world.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        int result = 0, maxSum = 0, floor = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            floor++;//层号
            int currentFloorSize = queue.size();
            int currentFloorSum = 0;
            while (currentFloorSize-- > 0) {
                TreeNode poll = queue.poll();
                currentFloorSum += poll.val;
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            if (currentFloorSum > maxSum) {
                maxSum = currentFloorSum; //更新最大层元素和
                result = floor; //更新层号
            }
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
