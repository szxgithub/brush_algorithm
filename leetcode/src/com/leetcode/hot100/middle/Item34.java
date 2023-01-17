package com.leetcode.hot100.middle;

import java.util.Arrays;

public class Item34 {

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     *
     * 给你一个按照非递减顺序排列的整数数组nums  和一个目标值target，请你找出给定目标在数组中的开始位置和结束位置
     *
     * 如果数组中不存在目标值target 返回[-1,1]
     * 你必须设计并实现时间复杂度为O(logn)的算法解决此问题
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target){
        int[] pos = new int[]{-1,-1};
        for (int i = 0; i< nums.length;i++){
            int num = nums[i];
            if (num == target){
                if (pos[0] == -1){
                    pos[0] = i;
                }
            }
        }

        for (int i = nums.length - 1; i>=0;i--){
            int num = nums[i];
            if (num == target){
                if (pos[1] == -1){
                    pos[1] = i;
                }
            }
        }

        return pos;
    }

    /**
     * 时间复杂度满足要求
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange2(int[] nums, int target){
        int[] pos = new int[]{-1,-1};

        int len = nums.length;

        for (int i = 0, j = len-1; i <= j;){

            int mid = (j+i)/2;
            if (nums[mid] > target){
                j = mid-1;
            }else if (nums[mid] < target){
                i = mid + 1;
            }else {
                pos[0] = pos[1] = mid;
                for (int k = mid+1; k < nums.length; k++){
                    if (nums[k] != nums[mid]){
                        break;
                    }
                    pos[1] = k;
                }
                for (int k = mid-1; k >= 0; k--){
                    if (nums[k] != nums[mid]){
                        break;
                    }
                    pos[0] = k;
                }
                break;
            }
        }

        return pos;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};

        int[] ints = searchRange2(nums, 8);
        System.out.println(Arrays.toString(ints));

    }

    public int binarySearch(int[] nums, int target,boolean lower){
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)){
                right = mid - 1;
                ans = mid;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
