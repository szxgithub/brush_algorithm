package com.leetcode.hot100.middle;

import static java.lang.Math.max;

public class Item55 {

    /**
     *
     * 跳跃游戏
     *
     * 给定一个非负整数数组nums，你最初位于数组的第一个下标
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums){
        int k = 0;
        for (int i = 0; i<nums.length; i++){
            if (i > k){
                return false;
            }
            k = max(k,i+nums[i]);
        }
        return true;
    }

    public static boolean canJump2(int[] nums){

        // 定义一个cover，表示当前元素能跳到的最大覆盖范围，每次我都只往右跳一格
        int cover = 0;
        for (int i = 0; i <= cover; i++){
            cover = Math.max(i+nums[i],cover);
            if (cover >= nums.length - 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        boolean b = canJump2(nums);
        System.out.println(b);
    }

}
