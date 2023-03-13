package com.leetcode.hot100.easy;

/**
 * 最大子数组和
 */
public class Item53 {

    //最大子序列和
    /*
    动态规划
    时间复杂度O(n)
     */
    public  int maxSubArray(int[] nums){
        int pre = 0, maxAns = nums[0];
        for (int x : nums){
            // 如果前边累加后还不如自己本身大，那就把前边的都扔掉，从此自己本身重新开始累加。
            pre = Math.max(pre + x,x);
            maxAns = Math.max(maxAns,pre);
        }
        return maxAns;
    }

    /*
    滑动窗口解法
     */
    public  int maxSubArray2(int[] nums){

        int left  = 0, right = 0;
        int windowSum = 0, maxSum = Integer.MIN_VALUE;
        while (right < nums.length){
            windowSum += nums[right];
            right++;

            maxSum = Math.max(maxSum,windowSum);

            while (windowSum < 0){
                windowSum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }

    /*
    前缀和解法
     */
    public  int maxSubArray3(int[] nums){

        int n  = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }

        int res = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i <n; i++){
            minVal = Math.min(minVal,preSum[i]);
            res = Math.max(res,preSum[i+1] - minVal);
        }
        return res;
    }


}
