package od2023.onehundred;

import java.util.Arrays;
import java.util.Scanner;

public class Main14 {

    /*
    模拟商场优惠打折

    有三种优惠券可以使用，满减，打折，无门槛
    满减券：满100减10，满200减20，满300减30，满400减40，以此类推不限制使用
    打折券：固定92折，且打折之后向下取整，每次购物只用一次
    无门槛：一张券减5元，无使用限制

    求不同使用顺序下，每个人用完券之后得到的最低价格和对应使用的优惠券的总数
    如果两种顺序得到的价格一样低，取使用优惠券数量较少的那个

输入：
3 2 5
3
100
200
400
输出：
65 6
135 8
275 8


     */

    /*
    逻辑分析
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 满减券数量
        int m = sc.nextInt();
        // 打折券数量
        int n = sc.nextInt();
        // 无门槛券数量
        int k = sc.nextInt();

        // 有x个人购物
        int x = sc.nextInt();
        int[] arr = new int[x];
        for (int i = 0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        getResult(arr,m,n,k);
    }

    /**
     *
     * @param arr
     * @param m
     * @param n
     * @param k
     */
    private static void getResult(int[] arr, int m, int n, int k) {

        for (int i = 0; i<arr.length; i++){
            Integer[][] ans = new Integer[4][2];
            int price = arr[i];

            // 满减
            int[] resM = M(price,m);
            // 打折
            int[] resN = N(price,n);

            // 先满减后打折
            int[] resM_N = N(resM[0],n);
            ans[0] = new Integer[]{
                    resM_N[0],m+n-resM[1] - resM_N[1]
            };

            // 先打折后满减
            int[] resNM_M = M(resN[0],m);
            ans[1] = new Integer[]{
                    resNM_M[0], n+m-resN[1] - resNM_M[1]
            };

            // 先满减再无门槛
            int[] resMK_K = K(resM[0],k);
            ans[2] = new Integer[]{resMK_K[0],m+k-resM[1] -resMK_K[1]};

            // 先打折再无门槛
            int[] resNK_K = K(resN[0],k);
            ans[3] = new Integer[]{resNK_K[0], n+k-resN[1] - resNK_K[1]};

            // 排序，先按剩余总价升序，再按使用掉的优惠券数量升序
            Arrays.sort(ans, (a,b)-> a[0].equals(b[0]) ? a[1] - b[1] : a[0]- b[0]);

            System.out.println(ans[0][0] + " "+ ans[0][1]);

        }
    }

    /**
     * 返回满减后的价格，和剩余的满减券
     * @param price
     * @param m
     * @return
     */
    public static int[] M(int price, int m){
        while (price >= 100 && m > 0){
            price -= price/100*10;
            m--;
        }
        return new int[]{price,m};
    }

    /**
     * 返回打折后的价格 和剩余打折券数量
     * @param price
     * @param n
     * @return
     */
    public static int[] N(int price, int n){
        if (n >= 1){
            // 打折之后向下取整
            price = (int)Math.floor((price*0.92));
            n--;
        }
        return new int[]{price,n};
    }

    /**
     * 返回无门槛券使用后的价格，和剩余的数量
     * @param price
     * @param k
     * @return
     */
    public static int[] K(int price, int k){
        while (price > 0 && k > 0){
            price -= 5;
            price = Math.max(price,0);
            k--;
        }
        return new int[]{price,k};
    }
}
