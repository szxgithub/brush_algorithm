package od2023;

import java.util.Scanner;

public class Main5 {

    /*

    信号发射和接收

    输入：
    1 6
    2 4 1 5 3 3
    输出：
    1 6
    0 1 1 2 1 1

     */


    private static int[][] matrix;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        matrix = new int[m][n];

        for (int i =0; i <m; i++){
            for (int j = 0;j <n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        String res = "";
        for (int i =0; i<m; i++){
            for (int j = 0; j <n; j++){
                int count = rowSignal(i,j) + colSignal(i,j);
                res += count + " ";
            }
        }

        System.out.println(m + " " + n);
        System.out.println(res.substring(0,res.length()-1));

    }

    public static int rowSignal(int row, int col){
        // 在0列，没有来自行方向的信号
        if (col == 0){
            return 0;
        }
        int  max = matrix[row][col-1];
        int count = 1;

        for (int i = col -2; i>=0; i--){
            // 当高度大于等于接收天线时，后面的天线发射的信号都无法接收
            if (max >= matrix[row][col]){
                break;
            }
            int height = matrix[row][i];
            if (height > max){
                count++;
                max = height;
            }
        }
        return count;
    }

    public static int colSignal(int row, int col){
        // 在0行，没有来自列方向上的信号
        if (row == 0){
            return 0;
        }

        int max = matrix[row-1][col];
        int count = 1;

        for (int i = row-2; i >= 0; i--){
            if (max>=matrix[row][col]){
                break;
            }
            int height = matrix[i][col];
            if (height > max){
                count++;
                max = height;
            }
        }
        return count;
    }

}
