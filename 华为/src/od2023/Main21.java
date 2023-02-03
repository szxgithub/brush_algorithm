package od2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main21 {

    /*

    微服务的集成测试

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
