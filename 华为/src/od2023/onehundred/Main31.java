package od2023.onehundred;

import java.util.ArrayList;
import java.util.Scanner;

public class Main31 {

    /*

    云短信平台优惠活动(最多获得的短信条数)

    输入描述：
        第一行客户预算M
        第二行给出出售价表，P1、P2、....Pn，
        Pi表示充值i元获得的短信条数  1 <= Pi<= 1000 1<= n <= 100
    输出描述：
        最多获得的短信条数

    输入：
    15
    10 20 30 40 60 60 70 80 90 150
    输出：
    210

     */

    /*
    通过回溯将所有充值的情形模拟一遍，求出其中最大的短信数
    回溯算法解法
     */
    public static int max = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 客户预算
        int M = sc.nextInt();
        sc.nextLine();

        String str = sc.nextLine();
        // 售价表序列
        String[] P = str.split(" ");

        combine(P,M,new ArrayList<>(),0);

        System.out.println(max);


    }


    /**
     *
     * M中取N个数的算法
     * @param p 出售价表
     * @param m 剩余的预算
     * @param list  充值获得短信条数的集合
     * @param index 出售价表的索引
     */
    private static void combine(String[] p, int m, ArrayList<Integer> list, int index) {

        // 预算等于0，退出循环
        if(m == 0){
            int count = 0;
            for (int i = 0; i<list.size();i++){
                count += list.get(i);
            }
            max = Math.max(max,count);
        }else {
            for (int i = index; i <p.length; i++){
                int x = Integer.valueOf(p[i]);
                list.add(x);
                combine(p,m-(i+1),list,i+1);
                list.remove(list.size()-1);
            }
        }

    }

    /*
    本题是完全背包问题
    预算M相当于背包的承重，
     */
    public int getResult(int m, int[] p){
        int[] dp = new int[m + 1];
        for (int i = 0; i<= p.length; i++){
            for (int j = 0;j<= m;j++){
                if (i == 0 || j== 0 || j < i){
                    continue;
                }
                dp[j] = Math.max(dp[j],dp[j-i] + p[i-1]);
            }
        }
        return dp[m];
    }

}
