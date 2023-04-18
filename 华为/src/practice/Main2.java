package practice;

public class Main2 {

    public static void main(String[] args) {


    }

    public int getResult(int[][] arr, int T){

        int maxI = arr.length + 1;
        int maxJ = T + 1;

        int[][] dp = new int[maxI][maxJ];
        for (int i = 0; i < maxI; i++){
            for (int j = 0; j < maxJ; j++){
                if (i == 0 || j == 0){
                    continue;
                }

                int t = arr[i-1][0];
                int w = arr[i-1][1];
                if (t > j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], w + dp[i-1][j-t]);
                }
            }
        }

        return dp[maxI-1][maxJ-1];

    }

}
