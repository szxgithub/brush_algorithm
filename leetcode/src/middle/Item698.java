package middle;

import java.util.Arrays;
import java.util.HashMap;

public class Item698 {

    /*

    划分为k个相等的子集

    给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。

     */

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if (sum % k != 0){
            return false;
        }
        int target = sum / k;
        // 排序优化
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return backtrack(nums, 0, new int[k], k, target);
    }
    private boolean backtrack(int[] nums, int index, int[] bucket, int k, int target) {
        // 结束条件优化
        if (index == nums.length){
            return true;
        }
        for (int i = 0; i < k; i++) {
            // 优化点二
            if (i > 0 && bucket[i] == bucket[i - 1]){
                continue;
            }
            // 剪枝
            if (bucket[i] + nums[index] > target){
                continue;
            }
            bucket[i] += nums[index];
            if (backtrack(nums, index + 1, bucket, k, target)){
                return true;
            }
            bucket[i] -= nums[index];
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
