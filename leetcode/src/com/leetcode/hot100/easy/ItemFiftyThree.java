package com.leetcode.hot100.easy;

/**
 * 最大子数组和
 */
public class ItemFiftyThree {

    //最大子序列和
    public  int maxSubArray(int[] nums){
        int pre = 0, maxAns = nums[0];
        for (int x : nums){
            pre = Math.max(pre + x,x);
            maxAns = Math.max(maxAns,pre);
        }
        return maxAns;
    }

}
