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

     */

    /*
     解题思路：
        求出红黑所有的配色方案，总数为2^n 个
        遍历所有的配色方案，是否有符合无相邻的红色，如不符合，则从总数-1

        该题n最大15，数量级不算大，暴力解法可行
     */
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);

        // 节点个数
        int n = sc.nextInt();
        // 边数
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
            // 给每个点染色
            int[] ints =new int[n];
            for (int j = 0; j<n; j++){
                ints[j] = temp%2;
                temp /= 2;
            }

            // 判断每一条边的相连节点 是否符合要求
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



}
