package middle;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Item1615 {

    /*
    最大网络秩

     */

    public int maximalNetworkRank(int n, int[][] roads) {

        boolean[][] connect = new boolean[n][n];
        int[] degree = new int[n];

        for (int[] v : roads){
            connect[v[0]][v[1]] = true;
            connect[v[1]][v[0]] = true;
            degree[v[0]]++;
            degree[v[1]]++;
        }

        int maxRank = 0;
        for (int i = 0; i <n; i++){
            for (int j = i+1; j<n; j++){
                int rank = degree[i] + degree[j] - (connect[i][j] ? 1 : 0);
                maxRank = Math.max(maxRank,rank);
            }
        }

        return maxRank;

    }

    public static void main(String[] args) {

        Item1615 item1615 = new Item1615();
       /* int n = 4;
        int[][] roads = {{0,1},{0,3},{1,2},{1,3}};*/

        int n = 2;
        int[][] roads = {{1,0}};
        int i = item1615.maximalNetworkRank(n, roads);
        System.out.println(i);

    }

}
