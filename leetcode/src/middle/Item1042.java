package middle;

import java.util.ArrayList;
import java.util.List;

public class Item1042 {

    /*

    不邻接植花

     */

    public int[] gardenNoAdj(int n, int[][] paths) {

        // 创建邻接表
        List<Integer>[] adj = new List[n];

        for (int i = 0; i <  n; i++){
            adj[i] = new ArrayList<Integer>();
        }

        for (int[] path : paths){
            adj[path[0] - 1].add(path[1] - 1);
            adj[path[1] - 1].add(path[0] - 1);
        }

        // 初始化时，每个花园的颜色都标记为0
        int[] ans = new int[n];

        for (int i = 0; i < n; i++){
            boolean[] colored = new boolean[5];
            // 遍历花园相邻的节点
            for (int vertex : adj[i]){
                colored[ans[vertex]] = true;
            }
            for (int j = 1; j <= 4; j++){
                //未被标记的颜色中找到一种颜色给当前的花园进行标记
                if (!colored[j]){
                    ans[i] = j;
                    break;
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {

    }

}
