package com.example.coding;

import java.util.*;
import java.util.stream.Collectors;

public class BusRoutesSecondAttempt {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // create the adjacency list and do a BFS.
        // map from routes to bus stops
        // Map bus stop to routes

        // start BFS from the source
        // get the routes and enter the bus stops to the queue.... check if bus route already visited

        List<List<Integer>> routesList = new ArrayList<>();
        Map<Integer, Set<Integer>> stopToRoutes = new HashMap<>();
        int m = routes.length;
        if(source==target)
            return 0;
        for(int i=0; i<m; i++) {
            List<Integer> l = new ArrayList<>();
            for(int j=0; j<routes[i].length; j++) {
                int stop = routes[i][j];
                l.add(routes[i][j]);
                if(stopToRoutes.containsKey(stop)) {
                    stopToRoutes.get(stop).add(i);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    stopToRoutes.put(stop, set);
                }
            }
            routesList.add(l);
        }

        Set<Integer> visitedRoutes = new HashSet<>();
        int distance = 0, counter = 0;
        Queue<Integer> queue = new LinkedList<>();
        if(stopToRoutes.containsKey(source))
            queue.add(source);
        int length = queue.size();
        while(!queue.isEmpty()) {
            int stop = queue.poll();
            counter++;
            if(stop==target) {
                return distance;
            }
            Set<Integer> routess = stopToRoutes.get(stop);
            routess.forEach(r -> {
                if(!visitedRoutes.contains(r)) {
                    visitedRoutes.add(r);
                    queue.addAll(routesList.get(r));
                }
            });

            if(length==counter) {
                length = queue.size();
                counter = 0;
                distance++;
            }
        }
        return -1;
    }
}
