package com.example.coding;

import java.util.*;

public class JobScheduling2 {
    /*
    1. Sort endTime and profit based on startTime
    2. Perform recurssion based on time to fetch max profit from a time
        Find a job with startTime just greater than time
        Two options
            a. Take this job
            b. Do not take this job
    */

    int[] memo = new int[50001];
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> schedules = new ArrayList<>();
        int length = startTime.length;

//        int[] memo = new int[startTime.length];

        Arrays.fill(memo, -1);

        for(int i=0; i<startTime.length; i++) {
            List<Integer> entry = new ArrayList<>();

            entry.add(startTime[i]);
            entry.add(endTime[i]);
            entry.add(profit[i]);

            schedules.add(entry);
        }
        schedules.sort(Comparator.comparingInt(schedule -> schedule.get(0)));

        for(int i=0; i<startTime.length; i++) {
            startTime[i] = schedules.get(i).get(0);
        }

        return findMaxProfit(schedules, startTime, length, 0);
    }

    private int findNextJob(int[] startTime, Integer integer) {

        int left = 0, right = startTime.length-1;
        int mid, sol = startTime.length;

        while(left<=right) {
            mid = (right + left) / 2;

            if(startTime[mid]>=integer) {
                sol = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return sol;
    }

    private int findMaxProfit(List<List<Integer>> schedules, int[] startTime, int length, int i) {

        if(i==length)
            return 0;

        if(memo[i]!=-1)
            return memo[i];

        int nextIndex = findNextJob(startTime, schedules.get(i).get(1));

        int maxProfit = Integer.max(findMaxProfit(schedules, startTime, length, i+1), schedules.get(i).get(2)+findMaxProfit(schedules, startTime, length, nextIndex));

        memo[i] = maxProfit;
        return memo[i];

    }
}
