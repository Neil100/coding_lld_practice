package com.example.coding;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        // -1 2 1 -4
        // 1

        // O(n^2)  O((n)log(n))
    	Arrays.sort(nums);
    	
    	int sol = Integer.MAX_VALUE, minPointer, maxPointer, val=0, checkSum, tempTarget;
    	
    	for(int i=0; i<(nums.length - 2); i++) {
    		minPointer = i+1;
    		maxPointer = nums.length - 1;
    		
    		// int tempTarget = target - nums[i];
    		
    		while(minPointer<maxPointer) {
    			checkSum = nums[minPointer] + nums[maxPointer] + nums[i];
                tempTarget = target - checkSum;
    			// checkSum = tempTarget - checkSum;
    			if(sol>(tempTarget<0 ? tempTarget*(-1) : tempTarget)) {
                    sol = (tempTarget<0 ? tempTarget*(-1) : tempTarget);
                    val = checkSum;
                }

    			if(tempTarget>=0)
    				minPointer++;
    			else
    				maxPointer--;
    			
    			// checkSum = checkSum<0 ? checkSum*(-1) : checkSum;
    		}
    	}
    	
    	return val;
    }
}
