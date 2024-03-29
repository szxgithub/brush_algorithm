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
     * 四层循环 暴力求解
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


    /*
    最优解
    二维矩阵前缀和解法
     */
    public int getResult(int[][] matrix, int n, int m, int c, int k){
        int[][] preSum = new int[n+1][m+1];

        // 求解二维矩阵前缀和
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                preSum[i][j] = preSum[i-1][j]  + preSum[i][j-1] - preSum[i-1][j-1] + matrix[i-1][j-1];
            }
        }

        int ans = 0;

        // 根据二维矩阵前缀和计算 区域面积
        for (int i = c; i <=n; i++){
            for (int j =c; j <= m; j++){
                int square = preSum[i][j] - (preSum[i-c][j] + preSum[i][j-c]) + preSum[i-c][j-c];
                if (square >= k){
                    ans++;
                }
            }
        }
        return ans;
    }

}
