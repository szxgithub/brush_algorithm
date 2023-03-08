package middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Item787 {

    /*
    K 站中转内最便宜的航班
     */

    int src;
    int dst;
    HashMap<Integer, List<int[]>> indegree;
    int[][] memo;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k){

        this.src = src;
        this.dst = dst;
        this.memo = new int[n][k+1];
        for (int[] row : memo){
            Arrays.fill(row,-1);
        }

        indegree = new HashMap<>();
        for (int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            indegree.putIfAbsent(to,new LinkedList<int[]>());
            indegree.get(to).add(new int[]{from,price});
        }

        return dp(dst,k);

    }

    int dp(int s, int k){
        if (s == src){
            return 0;
        }
        if (k < 0){
            return -1;
        }

        // 查找备忘录，防止冗余计算
        if (memo[s][k] != -1){
            return memo[s][k];
        }

        int res = Integer.MAX_VALUE;
        if (indegree.containsKey(s)){
            for (int[] v : indegree.get(s)){
                int from = v[0];
                int price = v[1];
                int subProblem = dp(from,k-1);
                if (subProblem != -1){
                    res = Math.min(res,subProblem + price);
                }
            }
        }

        res = res == Integer.MAX_VALUE ? -1 : res;
        memo[s][k] = res;
        return res;
    }

}
