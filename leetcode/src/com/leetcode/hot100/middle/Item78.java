package com.leetcode.hot100.middle;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Item78 {

    /**
     * 子集
     *
     * 给你一个整数数组nums, 数组中的元素互不相同，返回该数组所有可能的子集（幂集）
     * 解集不能包含重复的子集，可以按任意顺序返回解集
     *
     * @param nums
     * @return
     */

    public static List<List<Integer>> subsets(int[] nums){

        List<List<Integer>> res = new ArrayList<>();

        // 空集加入结果集
        res.add(new ArrayList<>());

        // 遍历数组，将每个数字生成的子集加入结果集
        for (int num : nums){
            Iterator<List<Integer>> iterator = res.iterator();

            // 获取当前数字能生成的子集，也就是遍历当前状态结果集下的所有子集，将当前元素加入进去
            List<List<Integer>> curNumLists = new ArrayList<>();

            while (iterator.hasNext()){
                List<Integer> integers = new ArrayList<>(iterator.next());
                integers.add(num);
                curNumLists.add(integers);
            }

            res.addAll(curNumLists);
        }

        // 返回结果集
        return res;
    }


    /**
     *
     * 递归方法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums){

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums){
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : result){
                ArrayList<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            result.addAll(newSubsets);
        }

        return result;
    }


    /**
     * 回溯法
     */
    List<List<Integer>> result = new ArrayList<>();
    int length = 0;
    public List<List<Integer>> subsets3(int[] nums){
        length = nums.length;
        for (int k = 0; k <= length; k++){
            backtrack(0,k,new ArrayList<Integer>(),nums);
        }
        return result;
    }

    /**
     *
     * @param start  子集第一个数在nums中的位置
     * @param k     当前需要构造子集的长度
     * @param cur   储存当前正在构造的子集
     * @param nums
     */
    public void backtrack(int start, int k, ArrayList<Integer> cur,int[] nums){
        if (k == 0){
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i<length; i++){
            cur.add(nums[i]);
            backtrack(i+1,k-1,cur,nums);
            cur.remove(cur.size()-1);
        }
    }


    public List<List<Integer>> subsets4(int[] nums){
        // 解集
        List<List<Integer>> lists = new ArrayList<>();
        // 首先将空集加入解集中
        lists.add(new ArrayList<>());

        for (int i = 0; i < nums.length;  i++){
            // 当前子集数
            int size = lists.size();
            for (int j = 0; j < size; j++){
                //  拷贝所有子集
                ArrayList<Integer> newList = new ArrayList<>(lists.get(j));
                newList.add(nums[i]);
                lists.add(newList);
            }
        }
        return lists;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3};

        Item78 item78 = new Item78();
        List<List<Integer>> subsets = item78.subsets3(nums);

        System.out.println(subsets);

    }

}
