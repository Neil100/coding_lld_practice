package com.example.coding;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        // sort based on the start
        // create priority queue to maintain the end time
    	int sol = Integer.MIN_VALUE;
    	Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    	if(intervals.length==0)
    			return -1;
    	
    	for(int i=0; i<intervals.length; i++) {
	    	while(!pq.isEmpty()) {
	    		if(intervals[i][0] >= pq.peek()) {
	    				pq.remove();
	    		} else {
	    			break;
	    		}
	    	}
	    		
	    	pq.add(intervals[i][1]);
	    	sol = Integer.max(sol, pq.size());
    	}

    	return sol;
    }
}
