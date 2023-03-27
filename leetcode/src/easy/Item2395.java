package easy;

import java.util.HashSet;
import java.util.Set;

public class Item2395 {

    /*
    和相等的子数组

     */

    public boolean findSubarrays(int[] nums) {

        Set<Integer> vis = new HashSet<>();
        for (int i = 1; i < nums.length; ++i) {
            if (!vis.add(nums[i - 1] + nums[i])) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Item2395 item2395 = new Item2395();
        int[] nums = {0,0};
        boolean subarrays = item2395.findSubarrays(nums);
        System.out.println(subarrays);
    }

}
