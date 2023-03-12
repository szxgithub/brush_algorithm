package od2023.onehundred;

import java.util.Arrays;
import java.util.Scanner;

public class Main26 {

    /*

    日志采集系统(日志首次上报最多积分)

    日志上报策略：
    1、成功上报一条，奖励1分
    2、延迟上报一秒，扣1分
    3、积累日志到100条，必须立即上报

    给出日志序列，根据规则计算首次上报能获得的最多积分数


    输入：3 7 40 10 60
    输出：37


     */

    /*
    第一种解法 逻辑分析 暴力求解
     */
    public static int[] ints;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] s = str.split(" ");
        // 按时序产生的日志条数
        ints = Arrays.stream(s).mapToInt(value -> Integer.valueOf(value)).toArray();

        // 统计日志总数
        int count = ints[0];
        int max = ints[0];

        if (ints[0] >= 100){
            System.out.println(100);
        }else {
            for (int i= 1; i<ints.length; i++){
                count += ints[i];
                if (count >= 100){
                    max = Math.max(max,100-jisuan(i));
                    break;
                }else {
                    max = Math.max(max,count - jisuan(i));
                }
            }

            System.out.println(max);

        }

    }

    /*
    计算index前日志扣除的分数
     */
    private static int jisuan(int index) {
        int score = 0;
        for (int i = 0; i <index; i++){
            score += ints[i]*(index - i);
        }
        return score;
    }

    /*
    动态规划思想
     */
    public int getResult(Integer[] arr){
        int n = arr.length;

        // dp[i]表示第i时刻可得正向得分
        int[] dp = new int[n];
        dp[0] = arr[0];

        // 第i时刻被扣除的负向分
        int[] delay = new int[n];
        delay[0] = 0;

        // 第i时刻最终得分
        int[] score = new int[n];

        for (int i = 1; i <n; i++){
            dp[i] = Math.min(100, dp[i-1] + arr[i]);
            delay[i] = delay[i-1] + dp[i-1];
            score[i] = dp[i] - delay[i];

            // 达到100条必须上报，此时首次上报已经完成
            if (dp[i] >= 100){
                break;
            }
        }

        int asInt = Arrays.stream(score).max().getAsInt();
        return asInt;
    }

}
