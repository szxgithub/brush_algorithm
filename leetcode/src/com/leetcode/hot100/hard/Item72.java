package com.leetcode.hot100.hard;

public class Item72 {

    /**
     *
     * 编辑距离
     *
     * 给你两个单词word1 和 word2
     * 请返回将word1转换成word2所使用的最少操作数
     *
     *
     * @param word1
     * @param word2
     * @return
     */


    /**
     *
     * 动态规划
     * dp[i][j] 代表word1到i位置转换成 word2到j位置需要的最少步数
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2){
        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1+1][n2+1];

        // 第一行
        for (int j = 1; j<=n2; j++){
            dp[0][j] = dp[0][j-1] + 1;
        }

        // 第一列
        for (int i = 1; i<=n1; i++){
            dp[i][0] =  dp[i-1][0] + 1;
        }

        for (int i = 1; i<=n1;i++){
            for (int j = 1;j<=n2; j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j]) + 1;
                }
            }
        }

        return dp[n1][n2];
    }

    /**
     * 动态规划
     *
     * 定义dp[i][j] 代表word1中前i个字符，变换到 word2中前j个字符，最短需要操作的次数
     *      需要考虑word1或word2一个字母都没有，即全增加/删除的情况，所以预留dp[0][j] 和 dp[i][0]
     *
     *  状态转移
     *      dp[i][j] = dp[i][j-1] + 1
     *      dp[i][j] = dp[i-1][j] + 1
     *      dp[i][j] = dp[i-1][j-1] + 1
     *
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance2(String word1, String word2){

        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        // 插入操作
        for (int i = 1; i<=len1; i++){
            dp[i][0] = dp[i-1][0] + 1;
        }

        for (int j = 1;j<=len2; j++){
            dp[0][j] = dp[0][j-1] + 1;
        }

        for (int i = 1;i<=len1;i++){
            for (int j = 1; j<=len2;j++){
                dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1])) + 1;

                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]);
                }

            }
        }

        return dp[len1][len2];

    }

}
