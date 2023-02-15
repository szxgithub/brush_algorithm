package easy;

import java.util.*;
import java.util.function.ToIntFunction;

public class Item496 {

    /*

    下一个更大元素 I

     */

    /*
    暴力解法  时间复杂度O(n^2)
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2){

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i<nums1.length; i++){
            int x = -1;
            for (int j = 0; j<nums2.length-1; j++){
                if (nums1[i] == nums2[j]){
                    for (int k = j+1; k <nums2.length; k++){
                        if (nums2[k] > nums1[i]){
                            x = nums2[k];
                            break;
                        }
                    }
                    break;
                }
            }
            res.add(x);
        }

        int[] ints = res.stream().mapToInt(value -> value).toArray();
        return ints;
    }


    /*

        单调栈解法

     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2){
        int[] result = new int[nums1.length];
        Map<Integer,Integer> map = nextGreaterElement(nums2);
        for (int i =0; i<nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    private Map<Integer, Integer> nextGreaterElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() <=  nums[i]){
                stack.pop();
            }
            map.put(nums[i],stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums[i]);
        }

        return map;

    }


    public static void main(String[] args) {

        int[] nums1 = {1,3,5,2,4};
        int[] nums2 = {6,5,4,3,2,1,7};

        Item496 item496 = new Item496();
        int[] ints = item496.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ints));

    }

}
