package od2023;

import java.util.Scanner;

public class Main9 {

    /*

    计算网络信号

    采用广搜数组办法

    输入：
    6 5
    0 0 0 -1 0 0 0 0 0 0 0 0 -1 4 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0
    2 1
    输出：0

    输入：
    6 5
    0 0 0 -1 0 0 0 0 0 0 0 0 -1 4 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0
    1 4
    输出：2

     */

    public static int pointI;
    public static int pointJ;
    public static int[][] signals;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        signals = new int[m][n];

        for (int i = 0; i< signals.length; i++){
            for (int j = 0; j < signals[i].length; j++){
                signals[i][j] = sc.nextInt();
            }
        }

        pointI = sc.nextInt();
        pointJ = sc.nextInt();

        int x = 0;
        int sourceI = 0;
        int sourceJ = 0;
        for (int i = 0; i<m; i++){
            for (int j = 0; j <n; j++){
                if (signals[i][j] != 0 && signals[i][j] != -1){
                    //找到信号所在地
                    x = signals[i][j];
                    sourceI = i;
                    sourceJ = j;
                }
            }
        }

        handle(sourceI,sourceJ,x);

        System.out.println(signals[pointI][pointJ]);

    }

    private static void handle(int sourceI, int sourceJ, int x) {

        // 到达所求位置
        if (sourceI == pointI && sourceJ == pointJ ){
            return;
        }

        // 无信号传播
        if (x == 0 || x == -1){
            return;
        }

        if (sourceI < pointI){
            if (signals[sourceI+1][sourceJ] != -1){
                signals[sourceI+1][sourceJ] = Math.max(signals[sourceI+1][sourceJ],x-1);
            }
            handle(sourceI+1,sourceJ,signals[sourceI+1][sourceJ]);
        }

        if (sourceJ < pointJ){
            if (signals[sourceI][sourceJ+1] != -1){
                signals[sourceI][sourceJ+1] = Math.max(signals[sourceI][sourceJ+1],x-1);
            }
            handle(sourceI,sourceJ+1,signals[sourceI][sourceJ+1]);
        }

        if (sourceI > pointI){
            if (signals[sourceI-1][sourceJ] != -1){
                signals[sourceI-1][sourceJ] = Math.max(signals[sourceI-1][sourceJ],x-1);
            }
            handle(sourceI-1,sourceJ,signals[sourceI-1][sourceJ]);
        }

        if (sourceJ > pointJ){
            if (signals[sourceI][sourceJ-1] != -1){
                signals[sourceI][sourceJ-1] = Math.max(signals[sourceI][sourceJ-1],x-1);
            }
            handle(sourceI,sourceJ-1,signals[sourceI][sourceJ-1]);
        }

    }

}
