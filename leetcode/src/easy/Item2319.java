package easy;

public class Item2319 {

    /*

    判断矩阵是否是一个 X 矩阵

     */

    public boolean checkXMatrix(int[][] grid){

        boolean isXMatrix = false;

        for (int i =0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){

                if (i == j){
                    if (grid[i][j] == 0){
                        return isXMatrix;
                    }
                }else if (i + j == grid.length-1){
                    if (grid[i][j] == 0){
                        return isXMatrix;
                    }
                }else if (grid[i][j] != 0){
                    return isXMatrix;
                }
            }
        }

        return !isXMatrix;

    }

}
