package com.leetcode.hot100.middle;

import java.util.ArrayList;
import java.util.Arrays;

public class Item75 {

    /**
     *
     * 颜色分类
     *
     * 给定一个包含红色、白色、和蓝色的共n个元素的数组nums
     * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排序
     *
     * 我们使用0、1 和 2分别表示红色、白色、和蓝色
     *
     * 必须在不使用sort库函数的情况下解决这个问题
     *
     *
     * @param nums
     */
    public static void sortColors(int[] nums){

        ArrayList<Integer> zeroList = new ArrayList<Integer>();
        ArrayList<Integer> oneList = new ArrayList<Integer>();
        ArrayList<Integer> twoList = new ArrayList<Integer>();

        for (int i = 0; i<nums.length; i++){
            if (nums[i] == 0){
                zeroList.add(nums[i]);
            }else if (nums[i] == 1){
                oneList.add(nums[i]);
            }else if (nums[i] == 2){
                twoList.add(nums[i]);
            }
        }

        zeroList.addAll(oneList);
        zeroList.addAll(twoList);

        for (int i = 0; i<zeroList.size(); i++){
            nums[i] = zeroList.get(i);
        }

    }

    /**
     *
     * 单指针
     *
     * 时间复杂度O（n）
     * 空间复杂度O(1)
     *
     * @param nums
     */
    public void sortColors2(int[] nums){

        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i<n; i++){
            if (nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }

        for (int i = ptr; i <n; i++){
            if (nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }

    }

    /**
     * 双指针
     *
     * @param nums
     */
    public void sortColor3(int[] nums){

        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; i++){
            if (nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            }else if (nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1){
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }

    }

    public void sortColors5(int[] nums){
        int len = nums.length;
        if (len < 2){
            return;
        }

        int zero = 0;
        int two = len;
        int i = 0;
        while (i < two){
            if (nums[i] == 0){
                swap(nums,i,zero);
                zero++;
                i++;
            }else if (nums[i] == 1){
                i++;
            }else {
                two--;
                swap(nums,i,two);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
