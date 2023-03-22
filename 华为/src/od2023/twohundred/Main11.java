package od2023.twohundred;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main11 {

    /*

    最优高铁城市修建方案
    设计算法，达到修建城市高铁的最低成本
    需要满足城市圈内两两互联可达

    输入描述：
        第一行，城市圈中城市的数量，可建高铁的两城市修建成本列表数量、必建高铁的城市列表
        可建高铁的两城市修建成本列表 (城市1id、城市2id、两城市修建成本) 每行3个数字
        固定要修建的高铁城市列表，是上面的子集  每行2个数字
    城市id从1开始编号，建设成本取值为正整数

    输出描述：
        修建城市圈高铁的最低成本、正整数，如果圈内存在两城市之间无法互联，返回-1


输入：
3 3 1
1 2 10
1 3 100
2 3 50
1 3
输出：
110

     */


    /*
    最小生成树问题

    有两种算法： prim算法和kruskal算法
    prim算法是基于顶点找最小生成树，kruskal算法是基于边找最小生成树

    生成树就是一个连通分量，初始时，生成树这个连通分量只有一个顶点(prim)，或者两个顶点(kruskal)，后面不断的加入新的顶点进来，扩大连通分量的范围

    连通分量可以使用并查集表示，并查集的本质是一个长度为n的数组，n为无向图的顶点数，初始时默认有n个连通分量

     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //城市数量
        int n = sc.nextInt();
        // 可修建的两城市修建成本列表数
        int can = sc.nextInt();
        // 必须修建的两城市列表（不包含成本）
        int must = sc.nextInt();

        int[][] cans = new int[can][3];
        for (int i = 0; i<can; i++){
            cans[i][0] = sc.nextInt();
            cans[i][1] = sc.nextInt();
            cans[i][2] = sc.nextInt();
        }

        int[][] musts = new int[must][2];
        for (int i = 0; i<must; i++){
            musts[i][0] = sc.nextInt();
            musts[i][1] = sc.nextInt();
        }


        int res = getResult(n,cans,musts);

        System.out.println(res);
    }

    /**
     * kruskal算法 基于边找最小生成树
     *         该算法要求将所有的边按照权重值升序排序
     *
     * @param n  城市的数量
     * @param cans  可建高铁城市成本列表
     * @param musts  必建高铁城市列表
     * @return
     */
    private static int getResult(int n, int[][] cans, int[][] musts) {

        // 定义一个并查集
        UnionFindSet ufs = new UnionFindSet(n);

        HashMap<String,Integer> cansMap = new HashMap<>();

        // key:城市id-城市id  value: 成本
        for (int[] can : cans){
            int city1 = can[0], city2 = can[1], fee = can[2];
            String key = city1 < city2 ?  city1 + "-" + city2 : city2 + "-" + city1;
            cansMap.put(key,fee);
        }

        //最少费用
        int minFee = 0;
        for (int[] must : musts){
            String key = must[0] < must[1] ? must[0] + "-" + must[1] : must[1] + "-" + must[0];
            minFee += cansMap.get(key);
            // 将必建高铁的两个城市纳入一个连通分量
            ufs.union(must[0],must[1]);
        }

        if (ufs.count == 1){
            return minFee;
        }

        // 将图的边按照成本费用升序
        Arrays.sort(cans,(a,b)->a[2] - b[2]);

        for (int[] can : cans){
            int city1 = can[0], city2 = can[1], fee = can[2];
            if (ufs.find(city1) != ufs.find(city2)){
                ufs.union(city1,city2);
                minFee += fee;
            }

            if (ufs.count == 1){
                break;
            }
        }


        // 连通分量个数大于1个，说明存在无法可达的两个城市
        if (ufs.count > 1){
            return -1;
        }

        return minFee;
    }

    static class UnionFindSet{
        int[] fa;
        int count;

        public UnionFindSet(int n){
            this.count = n;
            this.fa = new int[n + 1];
            for (int i = 0; i<n; i++){
                this.fa[i] = i;
            }
        }

        public int find(int x){
            if (x != this.fa[x]){
                return this.fa[x] = this.find(fa[x]);
            }
            return x;
        }

        public void union(int x, int y){
            int x_fa = find(x);
            int y_fa = find(y);
            if (x_fa != y_fa){
                this.fa[y_fa] = x_fa;
                this.count--;
            }
        }

    }

}
