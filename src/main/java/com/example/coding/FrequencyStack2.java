package com.example.coding;

import java.util.*;

import static java.lang.Integer.max;

public class FrequencyStack2 {

    int maxFreq, tempFreq, sol;
    Deque<Integer> tempList;
    Map<Integer, Deque<Integer>> freqToNumsMap;
    Map<Integer, Integer> numToFrequency;
    public FrequencyStack2() {
        this.maxFreq = 0;
        this.freqToNumsMap = new HashMap<>();
        this.numToFrequency = new HashMap<>();
    }

    public void push(int val) {

        tempFreq = this.numToFrequency.getOrDefault(val, 0)+1;
        maxFreq = max(maxFreq, tempFreq);

        this.numToFrequency.put(val, tempFreq);
        Deque<Integer> tempList = this.freqToNumsMap.getOrDefault(tempFreq, new ArrayDeque<>());
        tempList.push(val);
        freqToNumsMap.put(tempFreq, tempList);
    }

    public int pop() {
        sol = freqToNumsMap.get(maxFreq).poll();
        if(freqToNumsMap.get(maxFreq).size()==0) {
            maxFreq--;
        }
        tempFreq = this.numToFrequency.getOrDefault(sol, 0)-1;
//        maxFreq = max(maxFreq, tempFreq);

        this.numToFrequency.put(sol, tempFreq);
        return sol;
    }
}
