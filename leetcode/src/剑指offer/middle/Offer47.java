package 剑指offer.middle;

import java.util.ArrayList;
import java.util.List;

public class Offer47 {

    /*

    礼物的最大价值
     */

    public int maxValue(int[][] grid){
        int m = grid.length, n = grid[0].length;
        for (int i = 0;  i <m; i++){
            for (int j = 0; j < n; j++){
                grid[i][j] += maxNeighbour(grid,i,j);
            }
        }
        return grid[m-1][n-1];
    }

    int maxNeighbour(int[][] grid, int i, int j){
        if (i == 0 && j == 0){
            return 0;
        }
        // 该节点的左边
        if (i  == 0){
            return grid[i][j-1];
        }
        // 该节点的上边
        if (j == 0){
            return grid[i-1][j];
        }

        return Math.max(grid[i][j-1],grid[i-1][j]);
    }



    public static void main(String[] args) {

        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};

        Offer47 offer47 = new Offer47();
        int i = offer47.maxValue(grid);
        System.out.println(i);

    }

}
