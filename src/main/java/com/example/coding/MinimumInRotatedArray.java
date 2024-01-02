package com.example.coding;

public class MinimumInRotatedArray {
    public int findMin(int[] nums) {
        // find kink
    	// int sz = nums.length;
    	// int rightEnd = nums[nums.length-1], leftEnd = nums[0];
    	
    	int leftIndex = 0, rightIndex = nums.length-1, midIndex=0;
    	if(nums[0]>nums[nums.length-1]) {
        	while(leftIndex<=rightIndex) {
        		midIndex = (leftIndex + rightIndex)/2;
        		if((nums[midIndex]<=nums[nums.length-1] && nums[midIndex-1]>=nums[0])) {
        			break;
        		}
        		if(nums[midIndex]<nums[nums.length-1]) {
        			rightIndex = midIndex-1;
        		} else if(nums[midIndex]>leftIndex) {
        			leftIndex = midIndex+1;
        		}
        	}
        	
        	return nums[midIndex];
    	} else {
    		return nums[0];
    	}
    }
}
