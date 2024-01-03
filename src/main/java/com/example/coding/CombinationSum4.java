package com.example.coding;

import java.util.HashMap;
import java.util.Map;

public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        return combinationSum(nums, target, memo);
    }

    int combinationSum(int[] nums, int remain, Map<Integer, Integer> memo) {
        int newRemain, sol=0;
        if(memo.get(remain)!=null)
            return memo.get(remain);
        for(int i=0; i<nums.length; i++) {
            newRemain = remain - nums[i];
            if(newRemain==0) {
                ++sol;
            }
            if(newRemain>0) {
                sol +=combinationSum(nums, newRemain, memo);
            }
        }
        memo.putIfAbsent(remain, sol);
        return sol;
    }
}
