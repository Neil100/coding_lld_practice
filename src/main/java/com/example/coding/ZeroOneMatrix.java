package com.example.coding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length, n = mat[0].length;

        int[][] sol = new int[m][n];
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        Queue<Integer[]> queue = new LinkedList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                sol[i][j] = Integer.MAX_VALUE;
                if(mat[i][j]==0) {
                    Integer[] index = new Integer[2];
                    index[0] = i;
                    index[1] = j;
                    queue.add(index);
                    sol[i][j]=0;
                }

            }
        }

        int distance = 0;
        int qS = queue.size();
        while(!queue.isEmpty()) {
            qS--;
            Integer[] index = queue.poll();
            if(distance<=sol[index[0]][index[1]]) {
                sol[index[0]][index[1]] = distance;
                for(int i=0; i<directions.length; i++) {
                    int newI = index[0]+directions[i][0], newJ = index[1]+directions[i][1];
                    if(newI>=0 && newI<m && newJ>=0 && newJ<n) {
                        Integer[] newIndex = new Integer[2];
                        newIndex[0] = newI;
                        newIndex[1] = newJ;
                        queue.add(newIndex);
                    }
                }
            }
            if(qS==0) {
                qS = queue.size();
                distance++;
            }
        }

        return sol;
    }
}
