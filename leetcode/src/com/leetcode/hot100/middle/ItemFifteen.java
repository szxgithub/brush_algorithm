package com.leetcode.hot100.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
三数之和 排序和双指针
 */
public class ItemFifteen {

    public List<List<Integer>> threeSum(int[] nums){

        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for(int first = 0; first<n; first++){
            //需要和上一次枚举的数不相同
            if(first > 0 && nums[first] == nums[first-1]){
                continue;
            }

            //对应的指针初始指向数组的最右端
            int third = n -1;
            int target = -nums[first];

            for(int second = first + 1; second < n; second++){
                if(second > first+1 && nums[second] == nums[second-1]){
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target){
                    third--;
                }
                if(second == third){
                    break;
                }
                if(nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }

        return ans;
    }

}
