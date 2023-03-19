package od2023.onehundred;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main68 {

    /*

    Linux发行版的数量

    Linux操作系统有多个发行版，这些发行版相互存在关联，例如ubuntu基于debian开发，而mint又基于ubuntu开发

    给你一个n*n的矩阵 isConnected，其中isConnected[i][j] = 1表示第i个发行版和第j个发行版直接关联

    返回最大的发行版集中发行版的数量

    输入描述：
        第一行输入发行版的总数量N
        之后每行表示各发行版间是否直接相关
    输出描述：
        输出最大的发行版集中发行版的数量（发行版集是一个或多个相互存在关联的发行版）

输入：
4
1 1 0 0
1 1 1 0
0 1 1 0
0 0 0 1
输出：
3

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
                dfs(i);
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
    public static void dfs(int linux){

        for(int i=0; i<n; i++){
            if(!set.contains(i) && ints[linux][i] == 1){    //已经关联的版本无需处理
                set.add(i);     //添加到已关联的版本
                dfs( i);
            }
        }
    }

    /*
    满分
    也可也用并查集求解，
    求各个连通分量的节点数，输出最大连通分量的节点数
     */
    public static int getResult(int[][] matrix, int n) {
        UnionFindSet ufs = new UnionFindSet(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // j从i+1开始，是因为矩阵是对称的
                if (matrix[i][j] == 1) {
                    ufs.union(i, j);
                }
            }
        }

        // connected的key代表某个连通分量的顶级父节点，value代表该连通分量下的节点个数
        HashMap<Integer, Integer> connected = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Integer fa = ufs.find(ufs.fa[i]);
            connected.put(fa, connected.getOrDefault(fa, 0) + 1);
        }

        // 返回最大节点数
        return connected.values().stream().max((a, b) -> a - b).get();
    }

    // 并查集实现
    static class UnionFindSet {
        int[] fa;
        int count;

        public UnionFindSet(int n) {
            this.count = n;
            this.fa = new int[n];
            for (int i = 0; i < n; i++) this.fa[i] = i;
        }

        public int find(int x) {
            if (x != this.fa[x]) {
                return (this.fa[x] = this.find(this.fa[x]));
            }
            return x;
        }

        public void union(int x, int y) {
            int x_fa = this.find(x);
            int y_fa = this.find(y);

            if (x_fa != y_fa) {
                this.fa[y_fa] = x_fa;
                this.count--;
            }
        }
    }

}
