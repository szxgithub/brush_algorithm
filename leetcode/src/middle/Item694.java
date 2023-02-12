package middle;

import java.util.HashSet;

public class Item694 {

    /*

        不同岛屿的数量

     */

    public int numDistinctIslands(int[][] grid){

        int m = grid.length, n = grid[0].length;

        HashSet<String> islands = new HashSet<>();

        for (int i =0; i<m; i++){
            for (int j = 0; j<n; j++){
                if (grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid,i,j,sb,666);
                    islands.add(sb.toString());
                }
            }
        }

        return islands.size();

    }

    public void dfs(int[][] grids, int i, int j, StringBuilder sb, int dir){
        int m = grids.length, n = grids[0].length;
        if (i <0 || j<0 || i >= m || j >= n){
            return;
        }

        if (grids[i][j] == 0 ){
            return;
        }

        grids[i][j] = 0;
        sb.append(dir).append(',');

        dfs(grids, i - 1, j, sb, 1);
        dfs(grids, i + 1, j, sb, 2);
        dfs(grids, i, j - 1, sb, 3);
        dfs(grids, i, j + 1, sb, 4);

        // 撤销该方向的操作
        sb.append(-dir).append(',');
    }


    public static void main(String[] args) {


    }

}
