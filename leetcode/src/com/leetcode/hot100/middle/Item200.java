package com.leetcode.hot100.middle;

public class Item200 {


    private int res = 0;

    public int numIslands(char[][] grid){

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j< grid[i].length; j++){
                // 取出所有的陆地
                if (grid[i][j] == '1'){
                    // 深度递归，遍历所有陆地
                    dfs(grid,i,j);
                    res++;
                }
            }
        }

        return res;

    }

    void dfs(char[][] grid, int r, int c){
        // 判断base case
        // 如果坐标(r,c)超出了网格范围，直接返回
        if (!inArea(grid,r,c)){
            return;
        }

        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] != '1'){
            return;
        }

        // 将格子标记为已遍历过
        grid[r][c] = '2';

        // 访问上下左右四个相邻节点
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);

    }

    // 判断(r,c)是否在网格中
    boolean inArea(char[][] grid, int r, int c){
        return r>=0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

}
