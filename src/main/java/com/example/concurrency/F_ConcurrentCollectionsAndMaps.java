package com.example.concurrency;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class F_ConcurrentCollectionsAndMaps {
//    Collections: Queue, BlockingQueue
//    Map: ConcurrentMap
//    And implementations

        // ConcurrentList

    // Vector and Stack are thread safe but poorly written, syncronized is used at method level to achieve syncronization

    // Copy on Write Arrays
        // Make a copy modify the copy and change the pointer in syncronized way to the new copy

    // Queue And Deque
        // ArrayBlockingQueue Fixed size, bounded
        // ConcurrentLinkedQueue Unbounded

    // Queue
        // Adding element to a already full queue
        // Removing element from an empty queue

            // BlockingQueue
                // boolean add(E e); throws IllegalArgumentException
                // boolean offer(E e); boolean offer(E e, timeOut, timeUnit); returns false if operation failed
                // void put(E e); blocks until a cell is available

            // BlockingDeque is similar to above --> addFirst, offerFirst, putFirst

    // Concurrent Maps --> ConcurrentHashMap / ConcurrentSkipListMap


    public static void main(String[] args) {

        ConcurrentHashMap<Integer, String> concurrentMap = new ConcurrentHashMap<>();

        String result = concurrentMap.search( 10_000, (k, v) -> v.startsWith("a") ? "a" : null);

        // searchKeys
        // searchValues
        // searchEntries

        ConcurrentHashMap<Integer, List<String>> concurrentMapTwo = new ConcurrentHashMap<>();
        Integer resultTwo = concurrentMapTwo.reduce(10_000, (k, v) -> v.size(), (value1, value2) -> Integer.max(value1, value2));

        ConcurrentHashMap<Integer, List<String>> concurrentMapThree = new ConcurrentHashMap<>();
        concurrentMapTwo.forEach(10_000, (k, v) -> v.removeIf(s -> s.length()>20));


        // ConcurrentSet

        Set<String> set = ConcurrentHashMap.<String>newKeySet();
        // no concurrent operaions

        // ConcurrentSkipList
            // ConcurrentSkipListMap
                // All references are AtomicReferences
            // ConcurrentSkipListSet
                //

    }
}
