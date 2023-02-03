package od2023;

import java.util.Scanner;

public class Main40 {

    /*
    工作安排
     */
   /* public static int T;
    public static int max = 0;
    public static int time = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 工作时长
        T = sc.nextInt();
        // 工作数量
        int n = sc.nextInt();

        int[][] work = new int[n][2];
        for (int i= 0; i<work.length; i++){
            work[i][0] = sc.nextInt();
            work[i][1] = sc.nextInt();
        }

        int res = 0;

        dfs(work,0,0,0);

        System.out.println(max);

    }

    private static void dfs(int[][] work, int index,int time, int sum) {

        if (time >=T) {
            if (time == T){
                max = Math.max(max, sum);
            }else {
                return;
            }
        }else {
            for (int i =index; i<work.length; i++){
                sum += work[index][1];
                time += work[index][0];
                dfs(work,i+1,time,sum);
                sum -= work[index][1];
                time -= work[index][0];
            }
        }
    }*/


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int n = sc.nextInt();

        int[] times = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }

        int res = handle(T, times, values);

        System.out.println(res);

    }

    /**
     * 动态规划
     * @param T         工作时长
     * @param times     任务工作数组
     * @param values    任务报酬数组
     * @return
     */
    public static int handle(int T, int[] times, int[] values){

        int[] dp = new int[T+1];    //相当于各个时间所能做的最大报酬

        for(int i=0; i<times.length; i++){
            for(int j=T; j>=times[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-times[i]] + values[i]);
            }
        }

        return dp[T];
    }

}
