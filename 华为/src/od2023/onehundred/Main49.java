package od2023.onehundred;

import java.util.*;

public class Main49 {

    /*

    查找单入口空闲区域

    给定一个mxn的矩阵，由若干字符‘X’ 和 ‘O’构成，‘X’表示该处已被占据，‘O’表示该处空闲，请找到最大的单入口空闲区域
    解释：空闲区域是由连通的‘O’组成的边界，位于边界的‘O’可以构成入口
        单入口空闲区域即有且仅有一个位于边界的O作为入口的

    输入描述：
        输入为两个数字，行数m、列数n
        剩余各行为矩阵各行元素，为'X'或'O',以空格分隔
    输出描述：
        若有唯一的区域，输出三个数字， 入口行、列坐标，大小
        若有多个区域，输出区域最大的
        若有多个区域相同的，输出区域大小，不需要输出坐标
        若没有，输出NULL

输入：
4 4
X X X X
X O O X
X O O X
X O X X
输出：
3 1 5

输入：
5 4
X X X X
X O O O
X X X X
X O O O
X X X X
输出：3


     */

    public static int m;
    public static int n;
    public static String[][] arr;
    public static int[] rukou = new int[2];
    public static int count = 0;
    public static String[][] matrix;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 行数
        m = sc.nextInt();
        // 列数
        n = sc.nextInt();
        sc.nextLine();

        matrix = new String[m][];
        for (int i =0; i<m; i++){
            String s = sc.nextLine();
            String[] tmp = s.split(" ");
            matrix[i] = tmp;
        }

        // 最大区域的大小
        int max = 0;
        //  最大单入口区域的入口坐标 和 其区域大小的集合
        List<int[]> region = new ArrayList<>();
        for (int i = 0; i <m; i++){
            for (int j = 0; j <n; j++){
                if (matrix[i][j].equals("O")){

                    matrix[i][j] = "X";

                    // 深度优先搜索
                    List<int[]> zuobiao = new ArrayList<>();
                    zuobiao.add(new int[]{i,j});
                    dfs(i,j,zuobiao);

                    // 只有一个入口区域
                    if (count == 1){
                        if (max == zuobiao.size()){
                            region.clear();
                        }else if (max < zuobiao.size()){
                            region.clear();
                            // 更新结果为最大的单入口区域，坐标
                            region.add(new int[]{rukou[0],rukou[1],zuobiao.size()});
                            max = zuobiao.size();
                        }
                    }
                    // 重置入口数量
                    count = 0;
                    // 重置入口坐标
                    rukou = new int[2];
                }
            }
        }

        // 如果有多个符合要求，则输出区域大小最大的单入口区域
        if (region.size() == 1){
            int[] res = region.get(0);
            System.out.println(res[0] + " " + res[1] + " " + res[2]);
        }else if (max != 0){
            // 若有多个符合要求的区域大小相同，输出区域最大的大小
            System.out.println(max);
        }else {
            // 若没有，输出null
            System.out.println("NULL");
        }
    }

    /**
     *
     * 深度优先搜索
     *
     * @param x 横坐标
     * @param y 纵坐标
     * @param list  区域内坐标的集合
     */
    public static void dfs(int x, int y, List<int[]> list){

        // 判断坐标是否位于边界上
        if (x == 0 || x == m-1 || y==0 || y == n-1){
            count++;
            rukou[0] = x;
            rukou[1] = y;
        }

        int[][] offset = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int k = 0; k < offset.length; k++) {
            int offsetX = offset[k][0];
            int offsetY = offset[k][1];

            int newI = x + offsetX;
            int newJ = y + offsetY;

            if (newI < 0 || newI >=m || newJ <0 || newJ>= n){
                continue;
            }

            if (matrix[newI][newJ].equals("O")){
                matrix[newI][newJ]="X";
                list.add(new int[]{newI,newJ});
                dfs(newI, newJ, list);
            }
        }


      /*  // 向下搜索
        if (x < m-1){
            if (matrix[x+1][y].equals("O")){
                matrix[x+1][y] = "X";
                list.add(new int[]{x+1, y});
                dfs(x+1,y,list);
            }
        }

        // 向右搜索
        if (y < n-1){
            if (matrix[x][y+1].equals("O")){
                matrix[x][y+1] = "X";
                list.add(new int[]{x,y+1});
                dfs(x,y+1,list);
            }
        }

        // 向上搜索
        if (y > 0){
            if (matrix[x][y-1].equals("O")){
                matrix[x][y-1] = "X";
                list.add(new int[]{x,y-1});
                dfs(x,y-1,list);
            }
        }*/
    }


}
