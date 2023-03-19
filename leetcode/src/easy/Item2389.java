package easy;

import java.util.Arrays;

public class Item2389 {

    /*
    和有限的最长子序列

     */

    /*
    逻辑分析
     */
    public int[] answerQueries(int[] nums, int[] queries) {

        int[] ans = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 0; i < queries.length; i++){
            int query = queries[i];
            int sum = 0;
            int count = 0;
            for (int j = 0; j < nums.length; j++){
                if ((sum + nums[j]) > query){
                    break;
                }
                sum += nums[j];
                count++;
            }
            ans[i] = count;
        }
        return ans;
    }

    public static void main(String[] args) {

        Item2389 item2389 = new Item2389();
        int[] nums = {2,3,4,5};
        int[] queries = {1};

        int[] ints = item2389.answerQueries(nums, queries);

        System.out.println(Arrays.toString(ints));

    }

}
