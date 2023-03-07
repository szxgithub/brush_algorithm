package od2023.twohundred;

import java.util.LinkedList;
import java.util.Scanner;

public class Main10 {

    /*

    计算网络信号（信号强度）
    array[m][n]的二维数组代表网格地图
    array[i][j]=0代表i行j列是空旷位置
    array[i][j]=x(x是正整数)代表i行j列是信号源，信号强度是X
    array[i][j]=-1代表i行j列是阻隔物
    信号源只有1个，阻隔物可能有0个或多个
    网络信号衰减是上下左右相邻的网格衰减1

    要求输出对应位置的网络信号值
    输入描述：
        第一行为m、n
        第二行为mxn个空格分割的数
        第三行为i、j代表计算的位置  i和j均从0开始


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


    /*

    采用广搜数组办法

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

    /**
     *
     * @param sourceI 信号源行坐标
     * @param sourceJ 信号源列坐标
     * @param x   信号源大小
     */
    private static void handle(int sourceI, int sourceJ, int x) {

        // 到达所求位置
        if (sourceI == pointI && sourceJ == pointJ ){
            return;
        }

        // 无信号传播
        if (x == 0 || x == -1){
            return;
        }

        // 四个方向进行搜索
        // 下
        if (sourceI < pointI){
            if (signals[sourceI+1][sourceJ] != -1){
                signals[sourceI+1][sourceJ] = Math.max(signals[sourceI+1][sourceJ],x-1);
            }
            handle(sourceI+1,sourceJ,signals[sourceI+1][sourceJ]);
        }

        // 右
        if (sourceJ < pointJ){
            if (signals[sourceI][sourceJ+1] != -1){
                signals[sourceI][sourceJ+1] = Math.max(signals[sourceI][sourceJ+1],x-1);
            }
            handle(sourceI,sourceJ+1,signals[sourceI][sourceJ+1]);
        }

        // 左
        if (sourceI > pointI){
            if (signals[sourceI-1][sourceJ] != -1){
                signals[sourceI-1][sourceJ] = Math.max(signals[sourceI-1][sourceJ],x-1);
            }
            handle(sourceI-1,sourceJ,signals[sourceI-1][sourceJ]);
        }

        // 上
        if (sourceJ > pointJ){
            if (signals[sourceI][sourceJ-1] != -1){
                signals[sourceI][sourceJ-1] = Math.max(signals[sourceI][sourceJ-1],x-1);
            }
            handle(sourceI,sourceJ-1,signals[sourceI][sourceJ-1]);
        }

    }

    /*
   同样是BFS搜索，代码量少些
     */
    public int getResult(int[] arr, int m, int n, int tarI, int tarJ){
        LinkedList<Integer[]> queue = new LinkedList<>();

        for (int i = 0; i <m; i++){
            for (int j = 0; j <n; j++){
                if (arr[i*n+j] > 0){
                    queue.addLast(new Integer[]{i,j});
                    break;
                }
            }
        }

        // 上下左右
        int[][] offsets = {{-1,0},{1,0},{0,-1},{0,1}};

        while (queue.size() > 0){
            Integer[] pos = queue.removeFirst();
            int i = pos[0];
            int j = pos[1];

            int x = arr[i*n + j] - 1;
            if (x == 0){
                break;
            }

            for (int[] offset : offsets){
                int newI = i + offset[0];
                int newJ = j + offset[1];

                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && arr[newI*n + newJ] == 0){
                    arr[newI*n + newJ] = x;
                    queue.addLast(new Integer[]{newI,newJ});
                }
            }
        }

        return arr[tarI*n + tarJ];

    }

}
