package com.example.coding;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        // iterate through each word and perform DFS with set to maintain traversed index.
        int arr[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(performDFS(board, word, i, j, 0, set, arr)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean performDFS(char[][] board, String word, int i, int j, int index, Set<Integer> set, int[][] arr) {
        if(index==word.length())
            return true;

        if(word.charAt(index)==board[i][j]) {
            set.add((i*board.length)+j);

            for(int ii=0; ii<arr.length; ii++) {
                if((i+arr[ii][0])>=0 && (i+arr[ii][0])<=board.length && (j+arr[ii][1])>=0 && (i+arr[ii][0])<=board[0].length) {
                    if(!set.contains(((i+arr[ii][0])*board.length)+(j+arr[ii][1]))) {
                        if(performDFS(board, word, i+arr[ii][0], j+arr[ii][1], index+1, set, arr)) {
                            set.remove((i*board.length)+j);
                            return true;
                        }
                    }
                }
            }
            set.remove((i*board.length)+j);
            return false;
        }
        return false;
    }
}
