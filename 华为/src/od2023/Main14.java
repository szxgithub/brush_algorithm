package od2023;

import java.util.ArrayList;
import java.util.Scanner;

public class Main14 {

    /*

    云短信平台优惠活动

    通过回溯将所有充值的情形模拟一遍，求出其中最大的短信数

    输入：
    15
    10 20 30 40 60 60 70 80 90 150
    输出：
    210

     */

    public static int max = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        sc.nextLine();

        String str = sc.nextLine();
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

}
