package od2023.twohundred;

import java.util.Scanner;

public class Main4 {

    /*

    探索地块建立

    给你一块n*m的地块，相当于n*m的二维数组，每个元素的值表示这个地块的发电量

    求在这地上建立正方形的边长为c的发电站，发电量满足目标电量k的地块数量

    输入描述：
        第一行，n m c k
        后面n行整数，表示每个地块的发电量
    输出描述：
        输出满足条件的地块数量

    输入：
    2 5 2 6
    1 3 4 5 8
    2 3 6 7 1
    输出：4


     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        int k = sc.nextInt();

        int[][] land = new int[n][m];
        for (int i = 0; i<n; i++){
            for (int j = 0; j<m; j++){
                land[i][j] = sc.nextInt();
            }
        }

        int res  = getResult(land,c,k);
        System.out.println(res);
    }

    /**
     *
     * @param land
     * @param c  正方形的边长
     * @param k  目标电量
     * @return
     */
    private static int getResult(int[][] land, int c, int k) {
        int res = 0;
        int row = land.length;
        int col = land[0].length;

        // 四层循环 暴力求解
        for (int i = 0; i <= row - c; i++){
            for (int j = 0; j<= col - c; j++){

                int count = 0;
                for (int l = i; l < i + c; l++){
                    for (int m = j; m<j+c; m++){
                        count += land[l][m];
                    }
                }
                if (count >= k){
                    res++;
                }
            }
        }
        return res;
    }

}
