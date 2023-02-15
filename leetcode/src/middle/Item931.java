package middle;


import java.util.Arrays;

public class Item931 {

    /*

    下降路径最小和

     */

    /*

    动态规划，定义dp函数

     */
    int[][] memo;
    public int minFallingPathSum(int[][] matrix){

        int n = matrix.length;
        int res = Integer.MAX_VALUE;

        memo = new int[n][n];
        for (int i = 0; i<n; i++){
            Arrays.fill(memo[i],66666);
        }

        // 终点可能在最后一行的任何一列
        for (int i = 0; i <n; i++){
            res = Math.min(res,dp(matrix,n-1,i));
        }

        return res;
    }


    // 从第一行（matrix[0][..]）向下落，落到位置 matrix[i][j] 的最小路径和为 dp(matrix, i, j)
    int dp(int[][] matrix, int i, int j){
        if (i <0 || j<0 || i >= matrix.length || j >= matrix[0].length){
            return 99999;
        }

        if (i == 0){
            return matrix[0][j];
        }

        // 查找备忘录 防止重复计算
        if (memo[i][j] != 66666){
            return memo[i][j];
        }

        memo[i][j] = matrix[i][j] + min(dp(matrix,i-1,j),dp(matrix,i-1,j-1),dp(matrix,i-1,j+1));

        return memo[i][j];
    }

    // 求最小值
    int min(int a, int b, int c){
        return Math.min(a,Math.min(b,c));
    }

    /*

    动态规划，定义dp数组

     */
    public int minFallingPathSum2(int[][] matrix){

        int length = matrix.length;

        // dp[i][j]表示落到i,j时的最小路径和
        int[][] dp = new int[length][length];

        // dp[0][i] = matrix[0][i];

        for (int i = 0; i<length; i++){
            dp[0][i] = matrix[0][i];
        }
        for (int i =1; i<length; i++){
            for (int j = 0; j<length; j++){
                if (j == 0){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j+1]) + matrix[i][j];
                }else if (j == length - 1){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + matrix[i][j];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1])) + matrix[i][j];
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++){
            res = Math.min(res,dp[length-1][i]);
        }

        return res;

    }

    public static void main(String[] args) {
        Item931 item931 = new Item931();
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int i = item931.minFallingPathSum2(matrix);
        System.out.println(i);
    }

}
