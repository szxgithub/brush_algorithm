package middle;

import java.util.HashMap;
import java.util.Map;

public class Item1814 {

    /**
     *
     * 统计一个数组中好对子的数目
     *
     * */

    /**
     *
     * 暴力搜索
     * 超时 76/84
     *
     * */
    public int countNicePairs(int[] nums){
        int[] reverseNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            String s = String.valueOf(num);
            StringBuilder stringBuilder = new StringBuilder(s);
            StringBuilder reverse = stringBuilder.reverse();
            reverseNums[i] = Integer.parseInt(reverse.toString());
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if(nums[i] + reverseNums[j] == reverseNums[i] + nums[j]){
                    count++;
                }
            }
        }

        return count;

    }

    /***
     *
     * 通过
     * 哈希表计数解题
     *
     * @param nums
     * @return
     */
    public int countNicePairs2(int[] nums){

        final int MOD = 1000000007;

        long res = 0;

        Map<Integer,Integer> h = new HashMap<>();

        for (int i : nums){
            int temp = i, j = 0;
            while (temp > 0){
                j = j*10 + temp%10;
                temp /= 10;
            }

            h.put(i - j, h.getOrDefault(i-j,0) + 1);
        }

        for (long value : h.values()){
            res = (res + value*(value- 1)/2)%MOD;
        }
        return (int)res;
    }

    public static void main(String[] args) {

        int[] nums = {13,10,35,24,76};
        Item1814 item1814 = new Item1814();
        int i = item1814.countNicePairs(nums);
        System.out.println(i);

    }

}
