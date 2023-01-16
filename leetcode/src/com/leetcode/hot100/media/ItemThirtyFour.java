package com.leetcode.hot100.media;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class ItemThirtyFour {

    public static int[] searchRange(int[] nums, int target){

        int[] arr = new int[]{-1,-1};
        String str = Arrays.toString(nums);

        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l <= r){
            int mid = (r+l)/2;
            if(target > nums[mid]){
                l = mid + 1;
            }else if(target < nums[mid]){
                r = mid -1;
            }else {
                String num = String.valueOf(nums[mid]);
                arr[0] = str.indexOf(num);
                arr[1] = str.lastIndexOf(num);
                return arr;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        int[] res = searchRange(nums, target);
        System.out.println(res);
    }

    public  int[] searchRange2(int[] nums, int target){
        int leftIdx = binarySearch(nums,target,true);
        int rightIdx = binarySearch(nums,target,false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower){
        int left = 0, right = nums.length-1, ans = nums.length;
        while (left < right){
            int mid = (left + right)/2;
            if(nums[mid] > target || (lower && nums[mid] >= target)){
                right = mid - 1;
                ans = mid;
            }else {
                left = mid+1;
            }
        }
        return ans;
    }

}
