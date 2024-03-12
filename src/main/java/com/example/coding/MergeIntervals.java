package com.example.coding;

import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Arrays.sort;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int[] pair = new int[2];
        if(intervals.length==0)
            return new int[0][0];
        List<List<Integer>> sol = new ArrayList<>();
        pair[0]=intervals[0][0];
        pair[1]=intervals[0][1];
        sort(intervals);
        for(int i=1; i<intervals.length; i++) {
            if(intervalsOverlap(pair, intervals[i])) {
                pair[0] = min(intervals[i][0], pair[0]);
                pair[1] = max(intervals[i][1], pair[1]);
            } else {
                List<Integer> al = new ArrayList<Integer>();
                al.add(pair[0]);
                al.add(pair[1]);
                sol.add(al);

                pair[0] = intervals[i][0];
                pair[1] = intervals[i][1];
            }
        }
        List<Integer> al = new ArrayList<Integer>();
        al.add(pair[0]);
        al.add(pair[1]);
        sol.add(al);

        int[][] soll = new int[sol.size()][2];

        for(int i=0; i<sol.size(); i++) {
            soll[i][0] = sol.get(i).get(0);
            soll[i][1] = sol.get(i).get(1);
        }
        return soll;
    }

    private boolean intervalsOverlap(int[] pair, int[] interval) {
        if(pair[1]<interval[0])
            return false;

        if(pair[0]>interval[1])
            return false;

        return true;
    }
}
