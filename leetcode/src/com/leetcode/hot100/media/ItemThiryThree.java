package com.leetcode.hot100.media;

import java.util.Arrays;

/**
 * 搜索旋转排序数组
 */
public class ItemThiryThree {

    public int search(int[] nums, int target){
        for (int i = 0; i<nums.length;i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }


    public int search2(int[] nums, int target){

        int n = nums.length;
        if(n == 0){
            return  -1;
        }
        if(n == 1){
            return nums[0] == target ? 0 : -1;
        }

        int l = 0, r = n-1;
        while (l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[0] <= nums[mid]){
                if(nums[0] <= target && target <= nums[mid]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else {
                if(nums[mid] < target &&  target <= nums[n-1]){
                    l = mid +1;
                }else {
                    r = mid -1;
                }
            }
        }
        return -1;
    }

}
