package com.leetcode.hot100.media;

public class Item96 {

    /**
     *
     * 不同的二叉搜索树
     *
     * 给你一个整数n，求恰由n个节点组成节点值从1到n互不相同的二叉搜索树有多少种？
     *
     * 返回满足题意的二叉搜索树的种数
     *
     * @param n
     * @return
     */

    public int  numTrees(int n){
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++){
            for (int j = 1; j <= i; j++){
                G[i] += G[j-1]*G[i-j];
            }
        }

        return G[n];
    }

    public int numTrees2(int n){


        return getRes(0,n);

    }

    public int getRes(int left, int right){
        if (left == right || right - left == 1){
            return 1;
        }

        int numOfTree = 0;
        for (int i = left; i < right; i++){
            numOfTree += getRes(left,i) * getRes(i +1, right);
        }

        return numOfTree;
    }

    /**
     * 卡特兰数公式
     */
    public int numTrees3(int n){
        long C = 1;
        for (int i = 0; i < n; i++){
            C = C*2*(2*i+1)/(i+2);
        }
        return (int)C;
    }


    /**
     *
     * 动态规划
     *
     * @param n
     * @return
     */
    public int numTrees4(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = 1;j<=i;j++){
                int leftNum = dp[j-1];
                int rightNum = dp[i-j];
                dp[i] +=  leftNum*rightNum;
            }
        }

        return dp[n];
    }

}
