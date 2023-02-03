package od2023;

import java.util.Scanner;

public class Main20 {
    /*

    机器人活动区域

     */

    public static int M;
    public static int N;
    public static int[][] region;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        region = new int[M][N];

        for (int i = 0; i<M; i++){
            for (int j = 0; j<N; j++){
                region[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        for (int i =0; i<M; i++){
            for (int j = 0; j<N; j++){
                if (region[i][j] != -1){
                    int move = move(i, j, region[i][j]);
                    max = Math.max(max,move);
                }
            }
        }

        System.out.println(max);

    }

    public static int move(int row, int col, int val){
        // 越界了，返回0
        if (row < 0 || col <0 || row >= M || col >= M){
            return 0;
        }

        int currentNum = region[row][col];

        if (currentNum == -1 || Math.abs(currentNum - val) > 1){
            return 0;
        }

        // 已经统计过的网格置为-1
        region[row][col] = -1;
        // 符合要求的+1
        int count = 1;
        count += move(row -1,col,currentNum);
        count += move(row+1,col,currentNum);
        count += move(row,col-1,currentNum);
        count += move(row,col+1,currentNum);

        return count;
    }

}
