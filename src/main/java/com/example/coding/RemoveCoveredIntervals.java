package com.example.coding;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals {
    class Compare implements Comparator<int[]>  {

        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0]==o2[0])
                return o2[1]-o1[1];

            return o1[0] - o2[0];
        }
    }
    public int removeCoveredIntervals(int[][] intervals) {


        Arrays.sort(intervals, new Compare());
        int[] pair = new int[2];
        int sol = 0;
        if(intervals.length==0)
            return 0;
        pair[0]=intervals[0][0];
        pair[1]=intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            if(encompasses(pair, intervals[i])) {
                //    sol++;
            } else {
                sol++;
                pair[0] = intervals[i][0];
                pair[1] = intervals[i][1];
            }
        }

        return sol+1;

    }

    private boolean encompasses(int[] pair, int[] interval) {
        if(interval[1]<=pair[1])
            return true;
        return false;
    }
}
