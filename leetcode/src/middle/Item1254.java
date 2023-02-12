package middle;

public class Item1254 {

    /*

    统计封闭岛屿的数目

    二维矩阵 grid 由 0 （土地）和 1 （水）组成。


     */

    public int closedIsland(int[][] grid){

        int m= grid.length, n = grid[0].length;

        for (int j = 0; j<n; j++){
            // 把靠上边的岛屿淹掉
            dfs(grid,0,j);
            // 把靠下边的岛屿淹掉
            dfs(grid,m-1,j);

        }

        for (int i = 0; i<m; i++){
            // 把靠左边的岛屿淹掉
            dfs(grid,i,0);
            // 把靠右边的岛屿淹掉
            dfs(grid,i,n-1);
        }

        // 遍历grid，剩下的岛屿都是封闭岛屿
        int res = 0;
        for (int i = 0;i<m; i++){
            for (int j = 0; j<n; j++){
                if (grid[i][j] == 0){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;

    }

    public void dfs(int[][] grid,int i, int j){

        int m = grid.length, n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n){
            return;
        }

        if (grid[i][j] == 1){
            return;
        }

        grid[i][j] = 1;
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);

    }

}
