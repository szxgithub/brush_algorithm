package hard;

import java.util.Arrays;

public class Item174 {

    /*
     地下城游戏
     */

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i<= n; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        dp[n][m-1] = dp[n-1][m] = 1;
        for (int i = n-1; i>=0; i--){
            for (int j = m-1; j>=0;j--){
                int minn = Math.min(dp[i+1][j],dp[i][j+1]);
                dp[i][j] = Math.max(minn - dungeon[i][j],1);
            }
        }

        return dp[0][0];
    }

    int[][] memo; // 定义记忆化数组
    public int calculateMinimumHP2(int[][] dungeon) {
        memo = new int[dungeon.length][dungeon[0].length];
        return dfs(dungeon, dungeon.length, dungeon[0].length, 0, 0);
    }

    private int dfs(int[][] dungeon, int m, int n, int i, int j) {
        // 到达终点，递归终止。
        if (i == m - 1 && j == n - 1) {
            return Math.max(1 - dungeon[i][j], 1);
        }
        // 如果memo数组中有值，直接取出并返回，不进行后续的搜索。
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        // 同解法一，向右搜+向下搜
        int minRes = 0;
        if (i == m - 1) {
            minRes =  Math.max(dfs(dungeon, m, n, i, j + 1) - dungeon[i][j], 1);
        } else if (j == n - 1) {
            minRes = Math.max(dfs(dungeon, m, n, i + 1, j) - dungeon[i][j], 1);
        } else {
            minRes = Math.max(Math.min(dfs(dungeon, m, n, i + 1, j), dfs(dungeon, m, n, i, j + 1)) - dungeon[i][j], 1);
        }
        // 将结果存入memo数组
        return memo[i][j] = minRes;
    }

    public static void main(String[] args) {

    }

}
