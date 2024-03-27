package com.example.coding;

import java.sql.Array;
import java.util.*;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // BFS
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> li = new ArrayList<>();
        li.add(sr);
        li.add(sc);
        queue.add(new ArrayList<>(li));
        int[][] direction = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        while(!queue.isEmpty()) {
            li = queue.poll();
            for(int i=0; i<direction.length; i++) {
                int newR = li.get(0)+direction[i][0], newC = li.get(0)+direction[i][1];
                if(newR>=0 && newC>=0 && newR<image.length && newC<image[newR].length) {
                    if(image[newR][newC]!=0 && image[newR][newC]!=color) {
                        image[newR][newC] = color;
                        List<Integer> lo = new ArrayList<>();
                        lo.add(newR);
                        lo.add(newC);
                        queue.add(lo);
                    }
                }
            }

        }

        return image;
    }
}
