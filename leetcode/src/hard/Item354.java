package hard;

import java.util.Arrays;
import java.util.Comparator;

public class Item354 {

    /*

    俄罗斯套娃信封问题

     */

    public int maxEnvelopes(int[][] envelopes){
        int n = envelopes.length;
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        int[] height = new int[n];
        for (int i = 0;i <n; i++){
            height[i] = envelopes[i][1];
        }

        return lengthOfLTS(height);
    }

    public int lengthOfLTS(int[] nums){

        // 定义dp数组
        // dp[i]表示以nums[i]这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];

        // 初始化长度全为1
        Arrays.fill(dp,1);

        // if nums[i] <= nums[i-1]  dp[i] = dp[i-1]
        // if nums[i] > nums[i-1] dp[i] = dp[i-1] + 1

        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j <i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i<dp.length; i++){
            res = Math.max(res,dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Item354 item354 = new Item354();

        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        // int[][] envelopes1 = {{1,1},{1,1},{1,1},{1,1}};

        int i = item354.maxEnvelopes(envelopes);
        System.out.println(i);
    }

}
