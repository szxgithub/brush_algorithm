package od2023.twohundred;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main26 {

    /*

    荒地(光伏场地建设规划)
    电力公司希望在西北荒地建设多个光伏电站
    不能建设的区域发电量为0Kw，可以发电的区域每平方公里年发电量Xkw
    希望能够找到其中集中的矩形区域建设发电站

    输入描述：
        调研地区的长、宽、以及准备建设的电站的边长【正方形】最低要求的发电量
        每行为调研区域每平方公里的发电量
    输出描述：
        这样的区域有多少个

输入：
2 5 2 6
1 3 4 5 8
2 3 6 7 1
输出:
4

输入：
2 5 1 0
1 3 4 5 8
2 3 6 7 1
输出：
10

     这道题和”探索地块“那道题基本相似，区别在一句话：其中不能建设的区域发电量为0Kw

     */

    /*
   ，通过四层for循环来获取每个发电量区域的发电量，再判断发电量是否满足最低要求
     满分答案
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        // 正方形边长
        int s = sc.nextInt();
        // 最低发电量要求
        int min = sc.nextInt();

        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int result = 0;
        for (int i = 0; i + s <= r; i++){
            for (int j = 0; j + s <= c; j++){
                int sum = 0;
                for (int k = i; k <i+s; k++){
                    for (int l = j; l < j+s; l++){
                        sum += matrix[k][l];
                    }
                }
                if (sum >= min){
                    result++;
                }
            }
        }

        System.out.println(result);

    }



}
