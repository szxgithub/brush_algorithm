package od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main54 {


    /*

    欢乐的周末

    输入：
    4 4
    2 1 0 3
    0 1 2 1
    0 3 0 0
    0 0 0 0
    输出：
    2

Process finished with exit code 0


     */

    private static int endRow;
    private static int endCol;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] map = new int[m][n];

        for (int i = 0; i < m; i++){
            for (int j =0;j <n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        // 小华和小为的坐标
        List<int[]> list = new ArrayList<>();
        // 餐厅坐标
        List<int[]> dest = new ArrayList<>();

        for (int i =0; i<m; i++){
            for (int j = 0; j <n; j++){
                if (map[i][j] == 2){
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = j;
                    list.add(arr);
                }
                if (map[i][j] == 3){
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = j;
                    dest.add(arr);
                }
            }
        }

        int res = 0;

        // 遍历聚餐地点
        for (int i =0;i<dest.size(); i++){
            int[] place = dest.get(i);
            endRow = place[0];
            endCol = place[1];

            // 针对每个餐厅 分别计算小华和小为
            int[] xiaohua = list.get(0);
            int row = xiaohua[0];
            int col = xiaohua[1];
            int[][] tmpMap1 = copy(map);
            if (forEnd(row,col,tmpMap1) == 1){

                int[] xiaowei = list.get(1);
                row = xiaowei[0];
                col = xiaowei[1];
                int[][] tmpMap2 = copy(map);
                if (forEnd(row,col,tmpMap2) == 1){
                  res++;
                }

            }
        }

        System.out.println(res);

    }

    public static int[][] copy(int[][] nums){
        int x = nums.length;
        int y = nums[0].length;
        int[][] res = new int[x][y];
        for (int i =0; i<x; i++){
            for (int j = 0;j<y; j++){
                res[i][j] = nums[i][j];
            }
        }
        return res;
    }

    public static int forEnd(int row, int col, int[][] ints){

        int U = row - 1;
        int D = row + 1;
        int L = col - 1;
        int R = col + 1;

        if (row == endRow && col == endCol){
            return 1;
        }

        //对各种方向进行处理

        if (U >= 0){
            if (ints[U][col] != 1){
                // 通过后本格置为1，表示已经走过
                ints[row][col] = 1;
                // 递归处理
                if (forEnd(U,col,ints) == 1){
                    return 1;
                }
            }
        }

        if (D < ints.length){
            if (ints[D][col] != 1){
                ints[row][col] = 1;
                if (forEnd(D,col,ints) == 1){
                    return 1;
                }
            }
        }

        if (L >= 0){
            if (ints[row][L] != 1){
                ints[row][col] = 1;
                if (forEnd(row,L,ints) == 1){
                    return 1;
                }
            }
        }

        if (R < ints[0].length){
            if (ints[row][R] != 1){
                ints[row][col] = 1;
                if (forEnd(row,R,ints) == 1){
                    return 1;
                }
            }
        }

        return 0;

    }

}
