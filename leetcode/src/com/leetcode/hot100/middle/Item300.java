package com.leetcode.hot100.middle;

import java.util.Arrays;

public class Item300 {


    /*
    最长递增子序列

    给你一个整数数组nums, 找到其中最长严格递增子序列的长度
     */

    public int lengthOfLTS(int[] nums){

        // 定义dp数组
        // dp[i]表示以nums[i]这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];

        // 初始化长度全为1
        Arrays.fill(dp,1);

        // if nums[i] <= nums[i-1]  dp[i] = dp[i-1]
        // if nums[i] > nums[i-1] dp[i] = dp[i-1] + 1

        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j <i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i<dp.length; i++){
            res = Math.max(res,dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {10,9,2,5,3,7,101,18};
        Item300 item300 = new Item300();
        int i = item300.lengthOfLTS2(nums);
        System.out.println(i);

    }


    /*

    奇妙的解法 二分查找

     */
    int lengthOfLTS2(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数初始化为 0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];

            /***** 搜索左侧边界的二分查找 *****/
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            /*********************************/

            // 没找到合适的牌堆，新建一堆
            if (left == piles){
                piles++;
            }
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }

}
