package od2023.twohundred;

import java.util.*;

public class Main1 {

    /*

    红黑图（无向图染色）
    给一个无向图染色，可以填红黑两种颜色，必须保证相邻两个节点不能同时为红色，输出有多少种染色方案？
    不能保证所有节点都是连通的

    输入描述：
        第一行输入M（图中节点数） N（边数）
        后续N行格式为： v1 v2表示一个边
    输出描述：
        输出一个数字表示染色方案的个数


    输入：
    4 3
    0 1
    1 2
    2 3
    输出：
    8

    todo

     */

    /*

        暴力解法  n个数的全数组合数量一共有2^n - 1个
        该题n最大15，数量级不算大，暴力解法可行
     */
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 相连节点的集合
        List<int[]> list = new ArrayList<>();

        for (int i =0; i <m; i++){
            int[] points = new int[2];
            points[0] = sc.nextInt();
            points[1] = sc.nextInt();
            list.add(points);
        }

        // n个节点有2^n个红黑搭配
        int total = (int)Math.pow(2,n);
        int res = total;

        for (int i =0; i < total; i++){
            int temp = i;
            // 0 表示红 1表示黑
            int[] ints =new int[n];
            for (int j = 0; j<n; j++){
                ints[j] = temp%2;
                temp /= 2;
            }

            // 判断每一条边的相连节点
            for (int[] points : list){
                if (ints[points[0]] == 0 && ints[points[1]] == 0){
                    // 相连的节点都是红色，表示不符合
                    res--;
                    break;
                }
            }
        }

        System.out.println(res);

    }

    /**
     *
     * 求解无向图的各个连通分量，然后求各个连通分量各自的染色方案
     *
     * @param edges  各个边的关系
     * @param m 总共的点数
     * @return
     */
    public int getResult(int[][] edges, int m){
        // 用于存放每个节点的相邻节点
        HashMap<Integer, HashSet<Integer>> connect = new HashMap<>();

        for (int[] edge : edges){
            connect.putIfAbsent(edge[0],new HashSet<>());
            connect.get(edge[0]).add(edge[1]);

            connect.putIfAbsent(edge[1],new HashSet<>());
            connect.get(edge[1]).add(edge[0]);
        }

        //  节点从index = 1 开始， 必有count = 1个的全黑染色方案
        return dfs(connect,m,1,1,new LinkedList<>());


    }

    /**
     *
     * @param connect  各节点与其邻接点的关系
     * @param m        总共m个节点，编号从1开始
     * @param index
     * @param count
     * @param path
     * @return
     */
    private int dfs(HashMap<Integer, HashSet<Integer>> connect, int m, int index, int count, LinkedList<HashSet<Integer>> path) {

        if (path.size() == m){
            return count;
        }

        outter:
        for (int i = index; i <= m; i++){
            for (HashSet<Integer> p : path){
                if (p.contains(i)){
                    continue outter;
                }
            }
            count++;

            if (connect.containsKey(index)){
                path.addLast(connect.get(index));
                count = dfs(connect,m,index+1,count,path);
                path.removeLast();
            }else {
                count = dfs(connect,m,index+1,count,path);
            }
        }

        return count;
    }

}
