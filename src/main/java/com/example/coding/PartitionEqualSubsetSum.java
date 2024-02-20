package com.example.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

        int sum=0, length = nums.length;
        for(int i=0; i<nums.length; i++)
            sum = sum + nums[i];

        if(sum%2!=0)
            return false;

        Boolean[][] memo = new Boolean[sum+1][length];
        Arrays.fill(memo, false);
        sum = sum/2;

        for(int i=0; i<=sum; i++) {
            for(int j=0; j<length; j++) {
                if(i==0) {
                    memo[i][j] = true;
                    continue;
                }
                if(j==0) {
                    if(i-nums[j]==0) {
                        memo[i][j] = true;
                    } else {
                        memo[i][j] = false;
                    }
                    continue;
                }
                if(j!=0) {
                    // take the element
                    int tsum = i - nums[j];
                    if(tsum>=0) {
                        memo[i][j] = memo[tsum][j-1];
                    }

                    // do not take the element
                    memo[i][j] = memo[i][j] || memo[i][j-1];
                }

            }
        }

        return memo[sum][length-1];
    }
}
