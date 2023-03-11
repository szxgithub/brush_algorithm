package middle;

import java.util.Arrays;

public class Item518 {

    /*
     零钱兑换 II
     给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。

请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。

假设每一种面额的硬币有无限个。

     */

    /*
    采用回溯算法， 会超时 50%通过率
     */
    private int count;
    public int change(int amount, int[] coins){
        dfs(coins,0,amount,0);
        return count;
    }

    private void dfs(int[] coins, int index, int amount, int sum) {

        if (sum > amount){
            return;
        }else if (sum == amount){
            count++;
            return;
        }

        for (int i = index; i < coins.length; i++){
            sum += coins[i];
            dfs(coins,i,amount,sum);
            sum -= coins[i];
        }
    }

    public static void main(String[] args) {
        Item518 item518 = new Item518();
   /*     int[] coins = {1, 2, 5};
        int amount = 5;*/

        int[] coins = {3,5,7,8,9,10,11};
        int amount = 500;
        int change = item518.change(amount, coins);
        System.out.println(change);
    }

    /*
    零钱兑换 是一道背包问题， 这道题也是道完全背包问题
    采用动态规划思想解决

    这里定义一个二维数组  dp[i][j]的含义：使用前i个物品，背包容量为j的情况下，有dp[i][j]种方法装满
    换句话说，使用coins前i个硬币，凑出金额j，有dp[i][j]种凑法

    最终答案应该在dp[N][amount]的值

     */
    public int change1(int amount, int[] coins){
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // base case
        for (int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= amount; j++){
                if (j - coins[i-1]  >= 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }

    /*
    因为dp数组的转移只和dp[i][...] 和 dp[i-1][...]有关
    将上面二维数组压缩成功一维数组
     */
    public int change2(int amount, int[] coins){

        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i <n; i++){
            for (int j = 1; j <= amount; j++){
                if (j - coins[i] >= 0){
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }
        }
        return dp[amount];
    }


}
