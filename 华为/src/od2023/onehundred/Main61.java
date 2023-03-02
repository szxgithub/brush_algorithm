package od2023.onehundred;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main61 {

    /*

    微服务的集成测试

    给你一个nxn的二维矩阵useTime，其中
    useTime[i][i] = 10表示i服务自身启动加载需要消耗10s
    useTime[i][j] = 1 表示服务i启动依赖服务j完成

    服务之间没有循环依赖，若想对一个服务i进行集成测试，求最少需要等待多少时间

    输入：
    4
    2 0 0 0
    0 3 0 0
    1 1 4 0
    1 1 1 5
    4
    输出：
        12


     */

    /*
    深度优先搜索



     */
    public static int n;
    public static int[][] matrix;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 服务总量
        n = sc.nextInt();

        matrix = new int[n][n];

        for (int i =0; i<n; i++){
            for (int j = 0; j<n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        // 1<= k <= n
        int k = sc.nextInt();

        Integer handle = handle(k-1);

        System.out.println(handle);

    }

    public static Integer handle(int index){
        // 遍历第K行
        List<Integer> times = new ArrayList<>();
        for (int i = 0; i <n; i++){
            if (matrix[index][i] == 1 && index != i){
                times.add(handle(i));
            }
        }

        // 所依赖服务的最长启动时间
        int max = 0;
        for (int time : times){
            max = Math.max(max,time);
        }
        return max + matrix[index][index];
    }

}
