package od2023.twohundred;

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


     */

    /*
    这道题和探索地块那道题基本相似，区别在一句话：其中不能建设的区域发电量为0Kw
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int s = sc.nextInt();
        int min = sc.nextInt();

        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(getResult(matrix, r, c, s, min));
    }

    /**
     * @param matrix 调研区域每单元面积的发电量矩阵
     * @param r 调研区域的长，即行数
     * @param c 调研区域的宽，即列数
     * @param s 正方形电站的边长
     * @param min 正方形电站的最低发电量
     * @return 调研区域内有几个符合要求的正方形发电站
     */
    public static int getResult(int[][] matrix, int r, int c, int s, int min) {
        int[][] preSum = new int[r + 1][c + 1];
        ArrayList<Integer[]> zero = new ArrayList<>();

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (matrix[i - 1][j - 1] == 0) {
                    zero.add(new Integer[] {i, j});
                }

                preSum[i][j] =
                        preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int ans = 0;

        for (int i = s; i <= r; i++) {
            for (int j = s; j <= c; j++) {
                int square = preSum[i][j] - (preSum[i - s][j] + preSum[i][j - s]) + preSum[i - s][j - s];
                if (square >= min && !isIn(zero, new int[] {i, j}, s)) ans++;
            }
        }

        return ans;
    }

    /**
     * @param tars 不能建设的发电站的地块，即发电量为0的地块的位置集合
     * @param end 建设发电站正方形区域的右下角点位置
     * @param size 正方形的边长
     * @return 正方形内是否包含0发电量地块位置
     */
    public static boolean isIn(ArrayList<Integer[]> tars, int[] end, int size) {
        int ex = end[0];
        int ey = end[1];

        int sx = ex - size + 1;
        int sy = ey - size + 1;

        for (Integer[] tar : tars) {
            int tx = tar[0];
            int ty = tar[1];

            if (tx <= ex && tx >= sx && ty <= ey && ty >= sy) return true;
        }

        return false;
    }

}
