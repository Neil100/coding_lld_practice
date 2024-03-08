package com.example.coding;

import java.util.*;

class FreqStack {

    class FeqStackComparator implements Comparator<FreqStackModel> {
        @Override
        public int compare(FreqStackModel o1, FreqStackModel o2) {
            if(o1.freq > o2.freq) {
                return 1;
            } else if (o1.freq == o2.freq) {
                return o1.time-o2.time;
            }
            return -1;
        }
    }

    HashMap<Integer, Integer> strToFreq;
    PriorityQueue<FreqStackModel> pq;
    int timer;
    public FreqStack() {
        strToFreq = new HashMap<>();
        timer = 0;
        pq = new PriorityQueue<>(new FeqStackComparator());
    }

    public void push(int val) {
        timer++;
        int freq = strToFreq.getOrDefault(val, 0);
        strToFreq.replace(val, ++freq);

        pq.add(new FreqStackModel(val, timer, freq));
    }

    public int pop() {
        int val = pq.poll().str;
        return val;
    }
}