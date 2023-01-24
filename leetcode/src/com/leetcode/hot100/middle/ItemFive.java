package com.leetcode.hot100.middle;

public class ItemFive {

    /*
    最长回文字串
     */

    public String longestPalindrome(String s) {

        int len  =  s.length();
        if(len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        //dp[i][j]表示s[i..j]是否是回文串
        boolean[][] dp = new boolean[len][len];

        //初始化所有长度为1的字串都是回文串
        for(int i = 0; i<len; i++){
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();

        //先枚举字串长度
        for(int L = 2; L<=len; L++){
            //枚举左边界
            for(int i = 0;i<len;i++){
                //由L和i确定右边界
                int j = L + i - 1;
                if(j >= len){
                    break;
                }
                if(chars[i] != chars[j]){
                    dp[i][j] = false;
                }else{
                    if(j - i <3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && j-i+1 > maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }

        return s.substring(begin,begin + maxLen);
    }

    public static void main(String[] args) {
        ItemFive itemFive = new ItemFive();
        String babad = itemFive.longestPalindrome("babad");
        System.out.println(
                babad
        );
    }

}
