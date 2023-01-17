package com.leetcode.hot100.middle;

import java.util.*;

public class Item39 {

    /**
     * 给你一个无重复的整数数组，candidates和一个目标整数target，
     * 找出candidates中可以使数字和为目标数target的所有不同组合，并以列表形式返回，你可以按任意顺序返回这些组合
     *
     * candidates中的同一个数字可以无限制重复被选取，如果至少一个数字的被选数量不同，则两种组合是不同的
     *
     * 对于给定的输入，保证和为target的不同组合数少于150个
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target){

        int length = candidates.length;
        List<List<Integer>> res = new ArrayList<>();

        if (length == 0){
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,0,length,target,path,res);

        return res;
    }

    /**
     *
     * @param candidates 候选数组
     * @param begin 搜索起点
     * @param len
     * @param target  每减去一个元素，目标值变小
     * @param path  从根结点到叶子结点的路径，是一个栈
     * @param res   结果集列表
     */
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res){

        // target为负数和0的时候，不再产生新的孩子结点
        if(target < 0){
            return;
        }

        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        // 重点理解这里从begin开始搜索的语义
        for (int i = begin; i< len; i++){

            // 重点理解这里剪枝，前提候选数组已经有序
            if (target - candidates[i] < 0){
                break;
            }

            path.addLast(candidates[i]);

            // 注意：由于每一个元素可以重复使用，下一轮的搜索起点依然是i
            dfs(candidates,i, len, target - candidates[i], path, res);

            // 状态重置
            path.removeLast();
        }

    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        int len = candidates.length;
        List<List<Integer>>  res = new ArrayList<>();
        if (len == 0){
            return res;
        }

        // 排序是剪枝的前提
        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,0,len,target,path,res);

        return res;
    }




}

