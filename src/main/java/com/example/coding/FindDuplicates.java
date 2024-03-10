package com.example.coding;

public class FindDuplicates {
    public int findDuplicate(int[] nums) {
        int temp;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]<0)
                temp = -1*nums[i];
            else {
                temp = nums[i];
            }
            if(nums[temp]<0)
                return temp;
            else {
                nums[temp] = -1*nums[temp];
            }
        }
        return -1;
    }
}
