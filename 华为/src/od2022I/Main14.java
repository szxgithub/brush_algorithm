package od2022I;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main14 {

    /**
     *
     * 200分
     * 书籍叠放
     *
     * 给定一组书的长宽，并且只有当一本书的长宽同时小于另一本书的长宽时，两书才能叠放在一起，求改组书中最多能有多少本书叠放在一起
     *
     * 输入：
     *[[20,16],[15,11],[10,10],[9,10]]
     * 输出：
     * 3
     *
     *
     *
     * 动态规划，实质是求最长递增子序列，但本题有两个因素需要考虑，
     * 可以通过排序将长度置为有序，这样其实就是对宽度求最长递增子序列，且可能存在长度相同的情况，在更新dp数组判定时，也要考虑到
     * */


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){

            String str = scanner.nextLine();

            String str1 = str.replace("[[", "");
            String str2 = str1.replace("]]", "");
            String[] str3 = str2.split("],\\[");

            int[][] nums = new int[str3.length][2];
            for (int i = 0; i < str3.length; i++){
                String[] split = str3[i].split(",");
                int[] arr = new int[2];
                arr[0] = Integer.parseInt(split[0]);
                arr[1] = Integer.parseInt(split[1]);
                nums[i] = arr;
            }

            // 对输入的数组按照长度的大小进行排序
            Arrays.sort(nums, Comparator.comparingInt(o -> o[0]));

            // dp数组 dp[i]表示前i本书的最长子序列长度
            int[] dp = new int[nums.length];
            Arrays.fill(dp,1);

            // 初始为1，即至少可以放一本书
            int res = 1;

            // 从第2本书向前找，看看加上它能不能增加长度
            for (int i = 1; i < nums.length; i++){
                int[] cur = nums[i];
                for (int j = 0; j < i; j++){
                    int[] pre = nums[j];
                    if (cur[0] > pre[0] && cur[1] > pre[1]){
                        dp[i] = Math.max(dp[i],dp[j] + 1);
                    }
                    res = Math.max(res,dp[i]);
                }
            }

            System.out.println(res);

        }

    }


}
