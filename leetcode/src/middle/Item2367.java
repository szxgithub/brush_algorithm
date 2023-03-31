package middle;

import java.util.HashSet;

public class Item2367 {

    /*
        算术三元组的数目
     */

    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j =i+1; j < nums.length; j++){
                for (int k = j+1; k < nums.length; k++){
                    if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff){
                      count++;
                    }
                }
            }
        }

        return count;
    }

    public int arithmeticTriplets2(int[] nums, int diff) {

        int ans = 0;
        HashSet<Integer> set = new HashSet<>();

        for (Integer num : nums){
            set.add(num);
        }

        for (Integer num : nums){
            if (set.contains(num - diff) && set.contains(num + diff)){
                ans++;
            }
        }
        return ans;
    }



}
