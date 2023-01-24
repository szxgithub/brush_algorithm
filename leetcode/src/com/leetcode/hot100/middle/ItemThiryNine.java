package com.leetcode.hot100.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 */
public class ItemThiryNine {

    public List<List<Integer>> combinationSum(int[] candidates, int target){

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer>  combine = new ArrayList<>();

        dfs(candidates,target,ans,combine,0);


        return ans;




    }


    /**
     *
     * @param candidates
     * @param target
     * @param ans
     * @param combine 已经组合的列表
     * @param idx  candidates数组的第idx位
     */
    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {

        if(idx == candidates.length){
            return;
        }

        if(target == 0){
            ans.add(combine);
            return;
        }

        //直接跳过
        dfs(candidates,target,ans,combine,idx + 1);

        //选择当前数
        if(target - candidates[idx] >= 0){
            combine.add(candidates[idx]);
            dfs(candidates,target - candidates[idx],ans,combine,idx);
            combine.remove(combine.size() - 1);
        }

    }

}
