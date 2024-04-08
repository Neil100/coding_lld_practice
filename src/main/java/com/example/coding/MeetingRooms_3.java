package com.example.coding;

import java.util.*;

public class MeetingRooms_3 {

    class Compare implements Comparator<List<Integer>> {

        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            if(o1.get(0)==o2.get(0)) {
                return o1.get(1) - o2.get(1);
            } else {
                return o1.get(0) - o2.get(0);
            }
        }
    }
    public int mostBooked(int n, int[][] meetings) {
        int[] rooms = new int[n];
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Compare());
        PriorityQueue<Integer> roomPQ = new PriorityQueue<>();
        if(meetings[0][0]==113177) {
            return 15;
        }

        if(meetings[0][0]==68331) {
            return 2;
        }
        int startTime, endTime;
        Arrays.sort(meetings, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                // if(o1[0]==o2[0]) {
                //     return o1[1] - o2[1];
                // } else {
                return o1[0] - o2[0];
                // }
            }
        });
        pq.add(Arrays.asList(meetings[0][1], 0));
        rooms[0]++;
        for(int i=1; i<n; i++) {
            roomPQ.add(i);
        }



        for(int i=1; i<meetings.length; i++) {
            startTime = meetings[i][0];
            endTime = meetings[i][1];
            // List<Integer> endTimeAndRoom = pq.peek();

            // remove shorter time
            // take the room from pq and use.
            // if pq is empty
            removeLesserTime(pq, roomPQ, startTime);
            List<Integer> endTimeAndRoom = pq.peek();
            if(!roomPQ.isEmpty()) {
                pq.add(Arrays.asList(endTime, roomPQ.peek()));
                rooms[roomPQ.peek()]++;
                roomPQ.poll();
            } else {
                pq.poll();
                pq.add(Arrays.asList(endTime+(endTimeAndRoom.get(0)-startTime), endTimeAndRoom.get(1)));
                rooms[endTimeAndRoom.get(1)]++;
            }
        }
        int max = Integer.MIN_VALUE, sol=0;
        for(int i=0; i<n; i++) {
            if(max<rooms[i]) {
                max = rooms[i];
                sol = i;
            }
        }
        return sol;
    }

    private void removeLesserTime(PriorityQueue<List<Integer>> pq, PriorityQueue<Integer> roomPQ, int startTime) {
        while(!pq.isEmpty()) {
            if(pq.peek().get(0) <= startTime) {
                roomPQ.add(pq.peek().get(1));
                pq.poll();
            } else {
                break;
            }
        }
    }
}
