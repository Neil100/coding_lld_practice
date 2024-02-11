package com.example.coding;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        int[][] memo = new int[coins.length][amount+1];
        for(int i=0; i<memo.length; i++) {
            for(int j=0; j<memo[i].length; j++) {
               memo[i][j]=-1;
            }
        }
        recurssive_sol(coins, amount, 0, 0, memo);
        return memo[0][amount] == Integer.MAX_VALUE ? -1 : memo[0][amount];
    }

    int recurssive_sol(int[] coins, int amount, int i, int sol, int[][] memo) {

        if(amount==0) {
            memo[i][amount] = sol;
            return sol;
        }
//            return sol;
        if(amount<0 || i>= coins.length)
            return Integer.MAX_VALUE;

        if(memo[i][amount]!=-1)
                return memo[i][amount];
        memo[i][amount] =  Integer.min(recurssive_sol(coins, amount-coins[i], i, sol+1, memo), recurssive_sol(coins, amount, i+1, sol, memo));

        return memo[i][amount];
    }
}
