package com.example.coding;

import com.example.bookmyshow.Theatre;

import static java.lang.Math.max;

public class HouseRobber3 {
    public int rob(TreeNode root) {
        int[] maxN = new int[2], maxNotN = new int[2];
        recurssion(root, maxN, maxNotN);
        return max(maxN[0], maxNotN[0]);
    }

    void recurssion(TreeNode root, int[] maxN, int[] maxNotN) {
        maxN[0] = 0;
        maxNotN[0] = 0;
        if(root.left!=null) {
            recurssion(root.left, maxN, maxNotN);
        }
        int leftMaxN = maxN[0], leftMaxNotN = maxNotN[0];
        maxN[0] = 0;
        maxNotN[0] = 0;
        if(root.right!=null) {
            recurssion(root.right, maxN, maxNotN);
        }
        int rightMaxN = maxN[0], rightMaxNotN = maxNotN[0];

        maxN[0] = root.val + leftMaxNotN + rightMaxNotN;
        maxNotN[0] = max(max(max((leftMaxN + rightMaxN), leftMaxNotN+rightMaxN), leftMaxNotN+rightMaxNotN), leftMaxN+rightMaxNotN);
    }
}
