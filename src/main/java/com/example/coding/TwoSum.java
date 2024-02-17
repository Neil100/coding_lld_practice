package com.example.coding;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> targetToIndexMap = new HashMap<>();
        int[] sol = new int[2];

        for(int i=0; i<nums.length; i++) {
            if(targetToIndexMap.containsKey(nums[i])) {
                sol[0] = targetToIndexMap.get(nums[i]);
                sol[1] = i;
            } else {
                targetToIndexMap.putIfAbsent(target-nums[i], i);
            }
        }

        return sol;
    }
}
