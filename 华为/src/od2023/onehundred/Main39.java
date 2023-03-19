package od2023.onehundred;

import java.util.Scanner;

public class Main39 {

    /*
    工作安排（最大报酬）



    输入描述：
    第一行为两个正整数T、n
    T代表工作时长
    n代表工作数量
    接下来n行，每行包含两个整数t,w
    t代表该工作消耗时长，w代表该工作的报酬

    输出：
    输出小明指定工作时长内工作可获得的最大报酬

输入：
40 3
20 10
20 20
20 5
输出：
30

     */

    /**
     *
     * 这道题是0-1背包问题，可以使用动态规划求解
     *  工作时长相当于背包承重
     * 每一项工作相当于物品，工作消耗的时长相当于物品重量，工作报酬相当于物品价值
     *
     *
     * 根据0-1背包思想，采用动态规划
     * @param T  工作时长
     * @param tws  [该工作消耗时长，该工作的报酬]
     * @return  最大报酬
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int n = sc.nextInt();

        int[][] arr = new int[n][2];
        for (int i = 0; i< arr.length; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }


        int result = getResult(arr, T);
        System.out.println(result);

    }

    public static int getResult(int[][] tws, int T){

        int maxI = tws.length + 1;
        int maxJ = T + 1;

        //  dp[i][j]， 前i项工作 工作时长为j时，获得的最大报酬
        int[][] dp = new int[maxI][maxJ];

        for (int i = 0; i < maxI; i++){
            for (int j = 0; j < maxJ; j++){
                // 当工作为0或者工作时长为0，工作报酬为0，无需计算
                if (i == 0 || j == 0){
                    continue;
                }
                int t = tws[i-1][0];
                int w = tws[i-1][1];

                if (t > j){
                    // 如果要选择的工作时长 > 当前背包权重，则无法放入背包，最大价值继承自上一行该列的值
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],w + dp[i-1][j-t]);
                }
            }
        }

        return dp[maxI - 1][maxJ  - 1];

    }

}
