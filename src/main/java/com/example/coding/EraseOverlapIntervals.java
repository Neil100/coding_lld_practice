package com.example.coding;

import java.util.Arrays;

public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int k = Integer.MIN_VALUE;
        int sol = 0;
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);

        for(int i=0; i<intervals.length; i++) {
            if(intervals[i][0]>=k) {
                k = intervals[i][1];
            } else {
                sol++;
            }
        }

        return sol;
    }
}
