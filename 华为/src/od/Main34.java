package od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main34 {

    /**
     *
     * 跳格子游戏
     *
     * 利用深度优先搜索遍历图中的每个节点以及相邻节点
     * 如果图中有环，则两个格子一定相互依赖，也就无法跳完所有的格子
     * 参考：https://blog.csdn.net/JackSnack/article/details/124554285
     *
     * */

    // 记录每个节点的相邻节点
    public static List<List<Integer>> edges = new ArrayList<>();

    // 是否能够跳完所有格子
    public static boolean stepAllGrids = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        if (N < 1 || N >= 500){
            System.out.println("error:输入的格子个数应该大于等于1且小于500");
            return;
        }

        // 默认节点在 0~N-1之间
        for (int i = 0; i < N; i++){
            edges.add(new ArrayList<>());
        }

        stepAllGrids = true;
        while (!sc.hasNext("#")){

            String line = sc.nextLine();
            String[] strs = line.split(" ");

            if (strs.length != 2){
                System.out.println("error:输入的格子数组列数不为2");
                return;
            }

            int a = Integer.valueOf(strs[0]);
            if(a < 0 || a >= N) {
                System.out.println("error:输入的左侧格子号码应该大于等于0且小于" + N);
                return;
            }

            int b = Integer.parseInt(strs[1]);
            if(b < 0 || b >= N) {
                System.out.println("error:输入的右侧格子号码应该大于等于0且小于" + N);
                return;
            }
            edges.get(b).add(a);
        }

        if (step(N,edges)){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }

    }

    //节点遍历状态
    public static int[] visitStatus;
    public static boolean step(int N, List<List<Integer>> edges){
        visitStatus = new int[N];
        for(int i = 0; i < N && stepAllGrids; i++) {   //总是从节点0开始进入
            // 节点未访问过
            if(visitStatus[i] == 0) {
                dfs(i);
            }
        }
        return stepAllGrids;
    }

    public static void dfs(int node){
        visitStatus[node] = 1;
        for (int neighbor : edges.get(node)){
            if (visitStatus[neighbor] == 0){
                dfs(neighbor);
                if (!stepAllGrids){
                    return;
                }
            }else if (visitStatus[neighbor] == 1){
                stepAllGrids = false;
                return;
            }
        }
        visitStatus[node] = 2;
    }


}
