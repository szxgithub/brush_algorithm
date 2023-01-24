package com.leetcode.hot100.middle;

/**
 * 下一个排列
 */
public class ItemThirtyOne {

    public void nextPermutation(int[] nums) {

        //从后往前查找 尽可能靠右的低位交换
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //此时已经找到一个后面的小数，接着找到比当前这个数大的数
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            //交换
            swap(nums, i, j);
        }
        //将后面的数置为升序
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }


}
