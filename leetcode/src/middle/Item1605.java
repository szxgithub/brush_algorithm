package middle;

public class Item1605 {

    /*
     给定行和列的和求可行矩阵

    对于 matrix 的每一个位置 matrix[i][j] 我们将 matrix[i][j] 设为 min{rowSum[i],colSum[j]}
   然后将 rowSum[i],colSum[j] 同时减去 matrix[i][j]即可。
   当遍历完全部位置后，matrix即为一个满足要求的答案矩阵。

     */
    public int[][] restoreMatrix(int[] rowSum, int[] colSum){
        int row = rowSum.length;
        int col = colSum.length;

        int[][] res = new int[row][col];

        for (int i = 0; i <row; i++){
            for (int j = 0; j<col; j++){
                res[i][j] = Math.min(rowSum[i],colSum[j]);
                rowSum[i] -= res[i][j];
                colSum[j] -= res[i][j];
            }
        }

        return res;

    }

    /*
    贪心
     */
    public int[][] restoreMatrix2(int[] rowSum, int[] colSum){
        int row = rowSum.length;
        int col = colSum.length;
        int[][] res = new int[row][col];

        for (int i = 0; i < row; i++){
            int sum = rowSum[i];
            for (int j = 0; j < col; j++){
                if (sum <= colSum[j]){
                    res[i][j] = sum;
                    colSum[j] = colSum[j] - sum;
                    break;
                }else {
                    res[i][j] = colSum[j];
                    sum = sum - colSum[j];
                    colSum[j] = 0;
                }

                if (sum < 0){
                    break;
                }
            }
        }
        return res;
    }


}
