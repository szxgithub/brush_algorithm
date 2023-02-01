package od2023;

import java.util.Scanner;

public class Main8 {

    /*

    核酸检测人员安排

    求总最快检测效率

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //采样员数量
        int N = sc.nextInt();
        //志愿者数量
        int V = sc.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();     //采集员采样效率
        }

        int[] arrM = new int[N];
        for (int i = 0; i < N; i++) {
            arrM[i] = nums[i]/10;       //采集员浮动效率
        }
        int[][] dp = new int[N+1][V+1];
        int count = 0;
        for (int i = 1; i < N+1; i++) {
            count += (nums[i-1] - 2*arrM[i-1]);
            dp[i][0] = count;   //没有志愿者的采集员采样效率
        }

        for (int i = 1; i < N+1; i++) {     //采集员数量
            for (int j = 1; j < V+1; j++) {     //志愿者数量
                dp[i][j] = Math.max( dp[i-1][j]+nums[i-1]-2*arrM[i-1], dp[i-1][j-1]+nums[i-1]);     //志愿者大于等于1
                dp[i][j] = Math.max( dp[i][j], j-2 >= 0 ? dp[i-1][j-2]+nums[i-1]+arrM[i-1] : 0);    //志愿者大于等于2
                dp[i][j] = Math.max( dp[i][j], j-3 >= 0 ? dp[i-1][j-3]+nums[i-1]+2*arrM[i-1] : 0);  //志愿者大于等于3
                dp[i][j] = Math.max( dp[i][j], j-4 >= 0 ? dp[i-1][j-4]+nums[i-1]+3*arrM[i-1] : 0);  //志愿者大于等于4（题目强调最多提示3M）
            }
        }

        System.out.println(dp[N][V]);
    }

}
