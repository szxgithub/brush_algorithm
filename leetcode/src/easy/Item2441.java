package easy;

import java.util.HashMap;

public class Item2441 {

    /*
    与对应负数同时存在的最大正整数
     */
    public int findMaxK(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = -1;
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i],nums[i]);
            if (map.get(-nums[i]) != null){
                if (nums[i] > 0){
                    max = Math.max(max,nums[i]);
                }else {
                    max = Math.max(max,-nums[i]);
                }
            }
        }
        return max;
    }

}
