package od2023;

import java.util.Scanner;

public class Main68 {

    /*
    开心消消乐

    输入：
    4 4
    1 1 0 0
    0 0 0 1
    0 0 1 1
    1 1 1 1
    输出：
    2

    深度优先搜索
     */

    public static int[][] matrix;
    public static int N;
    public static int M;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        matrix = new int[N][M];
        for (int i =0; i<matrix.length; i++){
            for (int j = 0; j<matrix[i].length; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        // 求最少点击几次后，所有数字均为0
        int res = 0;
        for (int i = 0; i<N; i++){
            for (int j = 0; j<M; j++){
                if (matrix[i][j] == 1){
                    matrix[i][j] = 0;
                    clearHappy(i,j);
                    res++;
                }
            }
        }

        System.out.println(res);

    }

    private static void clearHappy(int i, int j) {

        if (i > 0){
            if (matrix[i-1][j] == 1){
                matrix[i-1][j] = 0;
                clearHappy(i-1,j);
            }
            if (j > 0){
                if (matrix[i-1][j-1] == 1){
                    matrix[i-1][j-1] = 0;
                    clearHappy(i-1,j-1);
                }
            }
            if (j < M-1){
                if (matrix[i-1][j+1] == 1){
                    matrix[i-1][j+1] = 0;
                    clearHappy(i-1,j+1);
                }
            }
        }

        if (i < N-1){
            if (matrix[i+1][j] == 1){
                matrix[i+1][j] = 0;
                clearHappy(i+1,j);
            }
            if (j > 0){
                if (matrix[i+1][j-1] == 1){
                    matrix[i+1][j-1] = 0;
                    clearHappy(i+1,j-1);
                }
            }
            if (j < M-1){
                if (matrix[i+1][j+1] == 1){
                    matrix[i+1][j+1] = 0;
                    clearHappy(i+1,j+1);
                }
            }
        }

        if (j > 0){
            if (matrix[i][j-1] == 1){
                matrix[i][j-1] = 0;
                clearHappy(i,j-1);
            }
        }

        if (j < M-1){
            if (matrix[i][j+1] == 1){
                matrix[i][j+1] = 0;
                clearHappy(i,j+1);
            }
        }

    }

}
