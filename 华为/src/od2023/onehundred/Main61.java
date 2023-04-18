package od2023.onehundred;

import java.util.*;

public class Main61 {

    /*

    微服务的集成测试

    给你一个nxn的二维矩阵useTime，其中
    useTime[i][i] = 10表示i服务自身启动加载需要消耗10s
    useTime[i][j] = 1 表示服务i启动依赖服务j完成

    服务之间没有循环依赖，若想对一个服务i进行集成测试，求最少需要等待多少时间

    输入描述：
        第一行输入服务总量n
        之后n行表示服务启动的依赖关系以及自身启动加载耗时
        最后输入k表示计算需要等待多少时间可以对服务k进行集成测试
    输出描述：
        最少需要等待多少时间后可以对服务k进行集成测试

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
    递归
    深度优先搜索

     */
    public static int n;
    static int[] cache;
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

        // 增加记忆化缓存，优化搜索
        cache = new int[matrix.length];
        Arrays.fill(cache,-1);

        // 从指定的服务k开始搜索
        Integer handle = dfs(k-1);

        System.out.println(handle);

    }

    /*
    利用递归
    深度优先搜索
     */
    public static Integer dfs(int index){

        if (cache[index] != -1){
            return cache[index];
        }

        // 存放第k个服务依赖的服务，每个服务的启动耗时
        List<Integer> times = new ArrayList<>();
        // 遍历第K行
        for (int i = 0; i <n; i++){
            if (matrix[index][i] == 1 && index != i){
                times.add(dfs(i));
            }
        }

        // 所依赖服务的最长启动时间
        int max = 0;
        for (int time : times){
            max = Math.max(max,time);
        }

        cache[index] = max + matrix[index][index];

        return max + matrix[index][index];
    }

}
