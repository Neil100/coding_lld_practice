package com.example.coding;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> minPQ = new PriorityQueue<>();
    PriorityQueue<Integer> maxPQ = new PriorityQueue<>(10, Collections.reverseOrder());

    public MedianFinder() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(10, Collections.reverseOrder());
    }

    public void addNum(int num) {
        maxPQ.add(num);

        int n = maxPQ.peek();
        maxPQ.remove();

        minPQ.add(n);

        if(minPQ.size()>maxPQ.size()) {
            int x = minPQ.peek();
            minPQ.remove();
            maxPQ.add(x);
        }
    }

    public double findMedian() {
        return maxPQ.size() > minPQ.size() ? maxPQ.peek() : (double) maxPQ.peek()+ (double)minPQ.peek())/2;
    }
}
