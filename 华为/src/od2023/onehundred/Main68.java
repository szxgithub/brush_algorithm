package od2023.onehundred;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main68 {

    /*

    Linux发行版的数量

    Linux操作系统有多个发行版，这些发行版相互存在关联，例如ubuntu基于debian开发，而mint又基于ubuntu开发

    给你一个n*n的矩阵 isConnected，其中isConnected[i][j] = 1表示第i个发行版和第j个发行版直接关联

    返回最大的发行版集中发行版的数量

     */

    public static int n;
    public static int[][] ints;
    public static Set<Integer> set;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 发行版的总量
        n = sc.nextInt();

        ints = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ints[i][j] = sc.nextInt();
            }
        }

        Set<Integer> temp = new HashSet<>();    //已经关联的linux版本集合
        int max = 0;
        for(int i=0; i<n; i++){
            if(!temp.contains(i)){  //已经关联过的linux版本不需要再处理
                set = new HashSet<>();
                handle(i);
                max = Math.max( max, set.size());   //set的大小代表发行版集中发行版的数量
                temp.addAll(set);   //处理过的linux加入已关联集合
            }
        }

        System.out.println(max);
    }

    /**
     * 找出所有与linux相关的版本  DFS搜索
     * @param linux
     */
    public static void handle(int linux){

        for(int i=0; i<n; i++){
            if(!set.contains(i) && ints[linux][i] == 1){    //已经关联的版本无需处理
                set.add(i);     //添加到已关联的版本
                handle( i);
            }
        }
    }

    /*
    也可也用并查集求解，输出最大连通分量的节点数
     */

}
