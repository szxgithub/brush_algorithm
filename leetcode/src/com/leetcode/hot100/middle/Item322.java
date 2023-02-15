package com.leetcode.hot100.middle;

import java.util.Arrays;

public class Item322 {

    /*

        零钱兑换

     */

    public int[] memo;
    public int coinChange(int[] coins, int amount){

        // 备忘录
        memo = new int[amount + 1];

        Arrays.fill(memo,-2);

        return dp(coins,amount);

    }

    private int dp(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        if (amount < 0){
            return -1;
        }
        if (memo[amount] != -2){
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins){
            int subproblem = dp(coins,amount-coin);
            if (subproblem == -1){
                continue;
            }
            res= Math.min(res,subproblem + 1);
        }
        memo[amount] = (res == Integer.MAX_VALUE) ? -1:res;
        return memo[amount];
    }

}
