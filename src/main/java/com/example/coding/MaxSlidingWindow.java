package com.example.coding;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 1 3 -1 -3 5 3 6 7
        int[] arr = new int[nums.length-k+1];
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0; i<nums.length; i++) {
            while(!dq.isEmpty() && nums[dq.peekFirst()]<=nums[i]) {
                dq.pollFirst();
            }
            dq.push(i);

            if(i-dq.peekLast()>=k) {
                dq.pollLast();
            }
            if(i>=k-1) {
                arr[i-(k-1)] = nums[dq.peekLast()];
            }
        }
        return arr;
    }
}
