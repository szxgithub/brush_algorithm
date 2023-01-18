package od;

import java.util.Scanner;

public class Main11 {

    /**
     * 第一行输入二维数组的行数和列数，以空格区分。然后输入矩阵，矩阵元素之间 同样以空格作为分隔符。
     * 求矩阵中和最大的矩阵。
     *
     * */

    public static void main2(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            int[][] matrix = new int[row][col];

            for (int i = 0; i< row; i++){
                for (int j = 0; j < col; j++){
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // 求第 i 行到第 j 行之间上下值的和
            int[][] total = matrix;
            for (int i = 1; i< matrix.length; i++){
                for (int j = 0; j < matrix[0].length; j++){
                    total[i][j]  += total[i-1][j];
                }
            }

            int maximum = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.length; i++){
                for (int j = i;j<matrix.length; j++){
                    //result 保存的是从 i 行 到第 j 行 所对应的矩阵上下值的和
                    int[] result = new int[matrix[0].length];
                    // 针对每一行，进行列的遍历
                    for (int f = 0; f < matrix[0].length; f++){
                        if (i == 0){
                            result[f] = total[j][f];
                        }else {
                            result[f] = total[j][f] - total[i - 1][f];
                        }
                    }

                    // 对一行求最大子段和
                    int maximal = maxSubsequence(result);
                    if (maximal > maximum) {
                        maximum = maximal;
                    }
                }
            }

            System.out.println(maximum);

        }

    }


    // 最大子段和
    public static int maxSubsequence(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] maxSub = new int[array.length];
        maxSub[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            maxSub[i] = (maxSub[i-1] > 0) ? (maxSub[i-1] + array[i]) : array[i];
            if (max < maxSub[i]) {
                max = maxSub[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[][] m = {{-1,3,-1},{-3,2,3},{4,5,3}};
        int i = maxSum(m);
        System.out.println(i);

    }


    public static int maxSum(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int[] s = null;
        // 遍历每一行
        for (int i = 0; i != m.length; i++) {
            // 准备放每一行各列的数据
            s = new int[m[0].length];
            // 遍历每一行
            for (int j = i; j != m.length; j++) {
                cur = 0;
                for (int k = 0; k != s.length; k++) {
                    s[k] += m[j][k];
                    // 求每一行的数据的最大子和
                    cur += s[k];
                    max = Math.max(max, cur);
                    cur = cur < 0 ? 0 : cur;
                }
            }
        }
        return max;
    }

}
