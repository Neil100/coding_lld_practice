package com.example.coding;

import static java.lang.Math.max;

public class BinaryTreeMaxPathSum {
    public int maxPathSum(TreeNode root) {
        int[] sol = new int[1];
        sol[0] = Integer.MIN_VALUE;

        evaluateMaxSum(root, sol);
        return sol[0];
    }

    int evaluateMaxSum(TreeNode root, int[] sol) {
        int leftSum = 0, rightSum = 0, lowerParabola = 0;
        if(root.left!=null) {
            leftSum = evaluateMaxSum(root.left, sol);
        }

        if(root.right!=null) {
            rightSum = evaluateMaxSum(root.right, sol);
        }
        lowerParabola = leftSum + rightSum + root.val;
        // if(leftSum!=Integer.MIN_VALUE)
        leftSum = leftSum + root.val;

        // if(rightSum!=Integer.MIN_VALUE)
        rightSum = rightSum + root.val;
        leftSum = max(leftSum, max(rightSum, root.val));
        sol[0] = max(sol[0],max(lowerParabola, leftSum));
        return (leftSum);
    }
}
