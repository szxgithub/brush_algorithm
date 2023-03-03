package od2023.onehundred;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main69 {

    /*

    信号发射和接收
    每根天线只能向东和向南发射信号

    每根天线都有自己的高度，存储在一个二维数组中
    对任一天线，天线X能接收到天线Y的条件是：
        1、天线X在天线Y的东边或南边
        2、天线X和天线Y之间的其他天线的高度都低于X和Y，或者之间无天线

    输入：
    1 6
    2 4 1 5 3 3
    输出：
    1 6
    0 1 1 2 1 1

     */

    /*
    好像通过部分测试用例
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


    /*
    采用单调递减栈
     */
    public String getResult(int[][] anth, int m, int n){
        int[][] ret = new int[m][n];

        // 先处理南向发射信号
        for (int j = 0; j < n; j++){
            LinkedList<Integer> stack = new LinkedList<>();
            for (int i = 0; i <m; i++){
                while (stack.size() > 0 && anth[i][j] > stack.getLast()){
                    ret[i][j] += 1;
                    stack.removeLast();
                }

                if (stack.size() > 0){
                    if (anth[i][j] == stack.getLast()){
                        ret[i][j] += 1;
                        stack.removeLast();
                    }else {
                        ret[i][j] += 1;
                    }
                }

                stack.add(anth[i][j]);
            }
        }

        /*
        用分割符拼接数组的需求很常见，Java标准库提供了一个StringJoiner
        String.join()方法内部使用了StringJoiner
         */
        StringJoiner sj = new StringJoiner(" ");

        for (int i = 0; i <m; i++){
            LinkedList<Integer> stack = new LinkedList<>();
            for (int j = 0; j <n; j++){
                while (stack.size() > 0 && anth[i][j] > stack.getLast()){
                    ret[i][j] += 1;
                    stack.removeLast();
                }
                if (stack.size() > 0){
                    if (anth[i][j] == stack.getLast()){
                        ret[i][j] += 1;
                        stack.removeLast();
                    }else {
                        ret[i][j] += 1;
                    }
                }

                stack.add(anth[i][j]);
                sj.add(ret[i][j] + "");
            }
        }

        return m + " " + n + "\n" + sj.toString();

    }

}
