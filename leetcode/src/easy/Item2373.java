package easy;

import java.util.Arrays;

public class Item2373 {

    /*

     矩阵中的局部最大值


     */

    public int[][] largestLocal(int[][] grid){

        int length = grid.length;
        int[][] arr = new int[length-2][length-2];
        for (int i = 0; i<length-2; i++){
            for (int j = 0; j<length-2;j++){

                int handle = handle(grid, i, j);
                arr[i][j] = handle;
            }
        }

        return arr;

    }

    private int handle(int[][] grid, int row, int col) {
        int max = Integer.MIN_VALUE;
        for (int i = row; i<row +3; i++){
            for (int j = col; j < col+3; j++){
                max = Math.max(grid[i][j],max);
            }
        }
        return max;
    }


    public static void main(String[] args) {

        Item2373 item2373 = new Item2373();

        // int[][] grid = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        int[][] grid = {{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}};

        int[][] ints = item2373.largestLocal(grid);
        for (int[] tmp : ints){
            System.out.println(Arrays.toString(tmp));
        }

    }

}
