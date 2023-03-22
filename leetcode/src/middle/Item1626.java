package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Item1626 {

    /*
    无矛盾的最佳球队

    这题可参考 “最长递增子序列”

     */
    public int bestTeamScore(int[] scores, int[] ages) {

        int n = scores.length;
        int[][] people = new int[n][2];
        for (int i = 0; i < n; ++i) {
            people[i] = new int[]{scores[i], ages[i]};
        }
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        // dp[i]为组建的球队中的最大球员序号为排序后的第i名球员时的，球队最大分数
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (people[j][1] <= people[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += people[i][0];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {

        Item1626 item1626 = new Item1626();
        int[] scores = {1,2,3,5};
        int[] ages = {8,9,10,1};
        int i = item1626.bestTeamScore(scores, ages);
        System.out.println(i);

    }

}
