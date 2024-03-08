package com.example.coding;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {
    public static final int[][] direction = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private int nRows, nColumns;
//    private int[][] topography;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> sol = new ArrayList<>();
        // DFS Solution
        if(heights.length==0 || heights[0].length==0)
            return new ArrayList<>();

        nRows = heights.length;
        nColumns = heights[0].length;
        boolean[][] pacificReachable = new boolean[nRows][nColumns];
        boolean[][] atlanticReachable = new boolean[nRows][nColumns];
//        topography = heights;

        for(int i=0; i<nRows; i++) {
            dfsReachable(i, 0, pacificReachable, heights);
            dfsReachable(i, nColumns-1, atlanticReachable, heights);
        }

        for(int i=0; i<nColumns; i++) {
            dfsReachable(0, i, pacificReachable, heights);
            dfsReachable(nRows-1, i, atlanticReachable, heights);
        }

        for(int i=0; i<nRows; i++) {
            for(int j=0; j<nColumns; j++) {
                if(pacificReachable[i][j] && atlanticReachable[i][j]) {
                    ArrayList<Integer> array = new ArrayList<>();
                    array.add(i);
                    array.add(j);
                    sol.add(array);
                }
            }
        }

        return sol;
    }

    private void dfsReachable(int row, int column, boolean[][] reachable, int[][] topography) {
        reachable[row][column] = true;
        int newRow, newColumn;
        for(int i=0; i< direction.length; i++) {
            newRow = row + direction[i][0];
            newColumn = column + direction[i][1];

            if(newRow<0 || newRow>=nRows || newColumn<0 || newColumn>=nColumns) {
                continue;
            }

            if(reachable[newRow][newColumn]) {
                continue;
            }

            if(topography[newRow][newColumn]<topography[row][column])
                continue;
            dfsReachable(newRow, newColumn, reachable, topography);
        }
    }
}
