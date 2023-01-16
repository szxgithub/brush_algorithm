package com.leetcode.hot100.media;

import java.util.Arrays;

public class Item62 {

    /**
     *
     * 不同路径
     *
     * 一个机器人位于一个mxn网格的左上角
     * 机器人每次只能向下或者向右移动一步，机器人试图达到网格的右下角
     * 问总共有多少条不同的路径
     *
     * m>=1
     * n>=1
     *
     * @param m
     * @param n
     * @return
     */

    /**
     * 动态规划
     * dp[i][j] 是到达i,j最多的路径
     * 动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
     *
     *
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n){
        int[][] dp = new int[m][n];
        for (int i=0; i<n; i++){
            dp[0][i] = 1;
        }
        for (int i = 0; i<m; i++){
            dp[i][0] = 1;
        }

        for (int i = 1; i<m; i++){
            for (int j = 1; j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     *
     * 空间复杂度优化 O(2n)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n){
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre,1);
        Arrays.fill(cur,1);

        for (int i = 1; i<m; i++){
            for (int j = 1;j<n;j++){
                cur[j] = cur[j-1] + pre[j];
            }
            pre = cur.clone();
        }
        return pre[n-1];
    }

}
