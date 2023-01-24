package com.leetcode.hot100.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组nums  返回其所有可能的  全排列
 */
public class ItemFourtySix {


    /*public List<List<Integer>>  permute(int[] nums){
        List<List<Integer>>  res = new ArrayList<>();

        List<Integer> output = new ArrayList<>();
        for (int num : nums){
            output.add(num);
        }

        int n = nums.length;
        backtrack(n,output,res,0);
        return res;
    }

    private void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        //所有数都填完了
        if(first == n){
            //这里注意重新构造一个list
            res.add(new ArrayList<>(output));
        }
        for (int i = first;i < n;i++){
            Collections.swap(output,first,i);
            backtrack(n,output,res,first+1);
            Collections.swap(output,first,i);
        }
    }*/

    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        //数组的长度
        int n = nums.length;
        //用于存放排好的一列数据
        List<Integer> list = new ArrayList<>(n);
        //初始化数组元素是否使用标记位
        boolean[] used = new boolean[n];
        int count = 0;
        //回溯
        backtrace(list, used, count, nums);
        return lists;
    }

    public void backtrace(List<Integer> list, boolean[] used, int count, int[] nums) {
        if (count == nums.length) {
            lists.add(new ArrayList(list));
            return;
        }
        //开始遍历
        for (int i = 0; i < used.length; i++) {
            //循环检查每一位是否使用
            if (!used[i]) {
                //如果未使用，则加入list
                list.add(nums[i]);
                //标记已使用
                used[i] = true;
                //再次进行回溯，以当前数字为基础进行排列
                backtrace(list, used, count + 1, nums);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

}
