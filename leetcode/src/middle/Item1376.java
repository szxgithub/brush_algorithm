package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Item1376 {

    /*
    通知所有员工所需的时间
     */

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime){
        List<Integer> g[] = new ArrayList[n];
        Arrays.setAll(g,e -> {
            return new ArrayList<>();
        });
        for (int i = 0; i <n; i++){
            if (manager[i] >= 0){
                g[manager[i]].add(i);
            }
        }
        return dfs(g,informTime,headID);
    }

    private int dfs(List<Integer>[] g, int[] informTime, int x) {
        int maxPathSum = 0;
        for (int y : g[x]){
            maxPathSum = Math.max(maxPathSum,dfs(g,informTime,y));
        }
        return maxPathSum + informTime[x];
    }

}
