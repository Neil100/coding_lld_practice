package com.example.coding;

import java.util.*;

public class TopKElements {
    class Word implements Comparable<Word>{
        String w;
        int freq;

        Word(String w, int freq) {
            this.w = w;
            this.freq = freq;
        }

        @Override
        public int compareTo(Word o) {
            if(this.freq==o.freq) {
                return this.w.compareTo(o.w);
            }
            return o.freq-this.freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        // create a list of word
        // word is a class with string and freq as the members
        // use priority queue to maintain the order of the memobers

        Map<String , Integer> wordToFreq = new HashMap<>();
        int freq;
        for(int i=0 ; i<words.length; i++) {
            freq = wordToFreq.getOrDefault(words[i], 0);
            wordToFreq.put(words[i], freq+1);
        }
        List<Word> wordList = new ArrayList<>();
        wordToFreq.forEach((key, v) -> wordList.add(new Word(key, v)));

        PriorityQueue<Word> pq = new PriorityQueue<>(wordList);

        List<String> sol = new ArrayList<>();

        for(int i=0; i<k; i++) {
            sol.add(pq.poll().w);
        }

        return sol;
    }
}
