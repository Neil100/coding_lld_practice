package com.example.coding;

import java.util.*;
import java.util.stream.Collectors;

public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // create the adjacency list and do a BFS.

        if(source==target)
            return 0;
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        for(int i=0; i<routes.length; i++) {
            Set<Integer> s = new HashSet<>();
            for(int j=0; j<routes[i].length; j++) {
                s.add(routes[i][j]);
            }
            for(int j=0; j<routes[i].length; j++) {
                if(adjacencyList.containsKey(routes[i][j])) {
                    Set<Integer> ss = adjacencyList.get(routes[i][j]);
                    ss.addAll(new HashSet<>(s));
                    adjacencyList.put(routes[i][j], ss);
                } else {
                    adjacencyList.put(routes[i][j], new HashSet<>(s));
                }
            }
        }


        Set<Integer> currentSet = new HashSet<>();
        int distance = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        int counter = 0;
        int qS = queue.size();
        while(!queue.isEmpty()) {
            int stop = queue.poll();
            counter++;
            if(!currentSet.contains(stop)) {
                currentSet.add(stop);
                Set<Integer> connections = adjacencyList.get(stop);
                if(connections.contains(target)) {
                    return distance;
                }
                List<Integer> nextSet = connections.stream().filter(c -> !currentSet.contains(c) && !queue.contains(c)).collect(Collectors.toList());
                if(!nextSet.isEmpty())
                    queue.addAll(nextSet);
            }
            distance++;
            if(counter==qS) {
                qS=queue.size();
                counter=0;
            }
        }

        return -1;
    }
}
