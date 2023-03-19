package od2023.onehundred;

import java.util.*;

public class Main67 {

    /*
        网上商城优惠活动（一）
        有三种优惠券可以用，满减卷，打折卷，和 无门槛卷

        每满100元优惠10元，无使用数限制，如100-199可以使用过1张减10，200-299可以使用2张减20，以此类推
        92折券，1次使用一张, 如果是小数，向下取整
        无门槛5元优惠券，无使用次数限制


        本题与第14道题优惠券打折非常相似，区别在于关于满减券的使用不同，导致最终实现结果也不同
        本题的意思是满100，最多使用一张，满200最多使用2张，以此类推...

        输入描述：
            优惠券的数量，满减、打折、无门槛
            购物人数
            之后每一行表示某个人购物优惠前的价格
        输出描述：
            每行输出每个人每次购物优惠后的最低价格以及使用的优惠券总数量
            每行的输出顺序 和 输入的顺序保持一致


     */

    /*
    分情况:
        先满减 后打折
        先打折 后满减
        先满减 后无门槛
        先打折 后无门槛

输入：
3 2 5
3
100
200
400
输出：
65 6
155 7
338 4

     */


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //各个优惠券数量
        int m = sc.nextInt();
        int d = sc.nextInt();
        int w = sc.nextInt();

        // 表示有n个人购物
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){

            Integer[][] ans = new Integer[4][2];

            int price = arr[i];

            int[] manjian = manjian(price, m);

            int[] dazhe =  dazhe(price, d);

            int[] manjian_dazhe = dazhe(manjian[0], d);
            ans[0][0] = manjian_dazhe[0];
            ans[0][1] = m - manjian[1] + d - manjian_dazhe[1];

            int[] dazhe_manjian = manjian(dazhe[0], m);
            ans[1][0] = dazhe_manjian[0];
            ans[1][1] = d - dazhe[1] + m - dazhe_manjian[1];

            int[] manjian_wmk = wmk(manjian[0], w);
            ans[2][0] = manjian_wmk[0];
            ans[2][1] = m - manjian[1] + w - manjian_wmk[1];

            int[] dazhe_wmk = wmk(dazhe[0], w);
            ans[3][0] = dazhe_wmk[0];
            ans[3][1] = d - dazhe[1] + w - dazhe_wmk[1];

            Arrays.sort(ans,(a,b)->{
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            });

            System.out.println(ans[0][0] + " " + ans[0][1]);

        }

    }

    /**
     * 满减后的价格
     * @param money
     * @return
     */
    public static int[] manjian(int money, int n){
        if(money/100 >= n){
            int price = money - n * 10;
            int remain = 0;
            return  new int[]{price,remain};
        }else {
            int price = money - (money / 100) * 10;
            int remain = n - (money/100);
            return  new int[]{price,remain};
        }
    }

    public static int[] dazhe(int money, int n){
        if ( n >= 1){
            money = (int) Math.floor(money*0.92);
        }
        return new int[]{money,n-1};
    }

    public static int[] wmk(int money, int n){
        while (money > 0 && n > 0){
            money = money - 5;
            money = Math.max(0,money);
            n--;
        }
        return new int[]{money,n};
    }


}
