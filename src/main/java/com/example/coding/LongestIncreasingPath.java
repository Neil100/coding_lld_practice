package com.example.coding;

import static java.lang.Integer.max;

public class LongestIncreasingPath {

    private int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    private int[][] dp;
    int sol = 0, tempSol;
    int m, n;
    public int longestIncreasingPath(int[][] matrix) {

        m = matrix.length;
        n = matrix[0].length;
        if(m==0)
            return sol;

        dp = new int[m][n];
        System.out.println(m);
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                sol = max(sol, dfs(matrix, i, j));
            }
        }
        return sol;
    }

    private int dfs(int[][] matrix, int index, int jndex) {
        if(dp[index][jndex]!=0)
            return dp[index][jndex];

        tempSol = 1;
        int newI, newJ;
        for(int i=0; i<directions.length; i++) {
            newI = index - directions[i][0];
            newJ = jndex - directions[i][1];
            if(newI>=0 && newI<m && newJ>=0 && newJ<n) {
                if(matrix[newI][newJ]>matrix[index][jndex])
                    tempSol = max(tempSol,dfs(matrix, newI, newJ)+1);
            }
        }
        dp[index][jndex] = tempSol;
        return tempSol;
    }
}
