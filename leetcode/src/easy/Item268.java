package easy;

import java.util.Arrays;

public class Item268 {

    /*

    丢失的数字
     */

    /*
    等差数列求和解法
     */
    public int missingNumber(int[] nums){

        int n = nums.length;
        int expect = (0 + n)*(n+1)/2;

        int sum = Arrays.stream(nums).sum();

        int res = expect - sum;
        return res;

    }

    public int missingNumber2(int[] nums){
        int res = 0;
        int n = nums.length;
        res ^= n;
        for (int i = 0; i<nums.length; i++){
           res ^= (nums[i]^i);
       }

        return res;

    }

    public static void main(String[] args) {
        Item268 item268 = new Item268();
        int[] nums1 = {3,0,1};
        int[] nums2 = {0,1};
        int[] nums3 = {9,6,4,2,3,5,7,0,1};
        int[] nums4 = {0};
        int i1 = item268.missingNumber(nums1);
        int i2 = item268.missingNumber(nums2);
        int i3 = item268.missingNumber(nums3);
        int i4 = item268.missingNumber(nums4);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
    }

}
