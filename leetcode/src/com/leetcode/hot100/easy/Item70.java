package com.leetcode.hot100.easy;

public class Item70 {

    /**
     *
     * 爬楼梯
     * 假设你正在爬楼梯，需要n阶你才能到达楼顶
     * 每次你可以爬1或2个台阶，你有多少种不同得方法可以爬到楼顶呢？
     *
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n){
       int p = 0, q = 0, r = 1;
       for (int i = 1; i <= n; ++i){
           p = q;
           q = r;
           r = p + q;
       }
       return r;
    }

    /**
     * 递归方法
     * 提交后部分测试用例超时
     * @param n
     * @return
     */
    public static int climbStaris2(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return climbStaris2(n -1 ) + climbStaris2(n -2);
    }

    /**
     *
     * 存储中间结果，避免重复计算
     *
     * @param n
     * @return
     */
    public int climbStairs3(int n){
        int[] memo = new int[n + 1];
        return climbStairsMemo(n, memo);
    }

    public int climbStairsMemo(int n, int[] memo){
        if (memo[n] > 0){
            return memo[n];
        }

        if (n == 1){
            memo[n] = 1;
        }else if (n == 2){
            memo[n] = 2;
        }else {
            memo[n] = climbStairsMemo(n-1,memo) + climbStairsMemo(n-2,memo);
        }
        return memo[n];
    }


    /**
     *
     * 动态规划方法
     *
     * @param n
     * @return
     */
    public int climbStairs4(int n){

        if (n == 1){
            return 1;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return  dp[n];
    }



    public static void main(String[] args) {
        int i = climbStaris2(45);
        System.out.println(i);
    }

}
