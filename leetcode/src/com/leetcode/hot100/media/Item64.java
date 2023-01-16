package com.leetcode.hot100.media;

public class Item64 {


    /**
     * 最小路径和
     *
     * 给定一个包含非负整数的mxn网格，请找出一条从左上角到右下角的路径，
     * 使得路径上得数字总和为最小
     *
     * @param grid
     * @return
     */

    /**
     * 不需要建立dp矩阵，这是因为原grid矩阵元素中被覆盖为dp元素后，不会再被使用到
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid){

       for (int i= 0; i < grid.length; i++){
           for (int j = 0; j<grid[0].length;j++){
               if (i == 0 && j == 0){
                   continue;
               }else if (i == 0){
                   grid[i][j] = grid[i][j-1] + grid[i][j];
               }else if (j == 0){
                   grid[i][j] = grid[i-1][j] + grid[i][j];
               }else {
                   // 目标位置上方方格、左边方格与目标位置之和
                   grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
               }
           }
       }
       // 返回右下角
       return grid[grid.length - 1][grid[0].length-1];
    }

    public int minPathSum2(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        // 初始化
        for (int i = 1; i < grid.length; i++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }

        for (int i = 1; i < grid[0].length; i++){
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }

        for (int i = 1; i < grid.length; i++){
            for (int j = 1; j < grid[0].length; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

}
