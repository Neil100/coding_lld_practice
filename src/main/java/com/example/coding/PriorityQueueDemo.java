package com.example.coding;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] agrs) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<10; i++) {
            pq.add(i);
        }

        System.out.println(pq);

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        pq2.addAll(pq);

        System.out.println(pq2);

        for(int i=0; i<10; i++) {
            System.out.println(pq2.poll());
        }

        class Ascending implements Comparator<Integer> {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        }
        PriorityQueue<Integer> pq3 = new PriorityQueue<>(new Ascending());
        pq3.addAll(pq);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        for(int i=0; i<10; i++) {
            System.out.println(pq3.poll());
        }
    }
}
