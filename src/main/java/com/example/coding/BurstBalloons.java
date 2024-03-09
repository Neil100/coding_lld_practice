package com.example.coding;

import static java.lang.Integer.max;

public class BurstBalloons {
    /*
        DP

        left.....right
        5 2 3
        5*2*3 + 5*3*1 + 1*5*1
        1*5*2 + 2*3*1 + 1*2*1


     */
    int[] dp, newNums;
    int[][] memo;
    int m, n;
    public int maxCoins(int[] nums) {
        m = nums.length;
        n = m + 2;
        newNums = new int[n];
        for(int i=1;i<n-1; i++) {
            newNums[i] = nums[i-1];
        }
        newNums[0] = 1;
        newNums[n-1] = 1;
        dp = new int[n];
        memo = new int[n][n];
        return dpEvaluation(1, n-2);
    }

    private int dpEvaluation(int left, int right) {
        int sol = 0;
        if(right<left) {
            return 0;
        }
        if(memo[left][right]!=0)
            return memo[left][right];
        for(int i=left; i<=right; i++) {
            sol = max(sol, dpEvaluation(left, i-1) + dpEvaluation(i+1, right) + (newNums[left-1]*newNums[i]*newNums[right+1]));
        }
        memo[left][right] = sol;
        return memo[left][right];
    }
}
