package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Item2341 {

    /*

    数组能形成多少数对

     */

    public int[] numberOfPairs(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        int couple = 0;
        int remain = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            Integer value = entry.getValue();
            if (value >= 2){
                couple += value/2;
                remain += value%2;
            }else {
                remain++;
            }
        }

        return new int[]{couple,remain};
    }

    public static void main(String[] args) {

        // int[] nums = {1,3,2,1,3,2,2};
        // int[] nums = {1,1};
        int[] nums = {0};
        Item2341 item2341 = new Item2341();
        int[] ints = item2341.numberOfPairs(nums);
        System.out.println(Arrays.toString(ints));

    }

}
