package od2023.onehundred;

import java.util.Scanner;

public class Main12 {

    /*

    狼羊过河
    羊、狼、农夫都在岸边，当羊的数量小于狼时，狼会攻击羊，农夫有一艘容量固定的船
    要求不损失羊的情况下，将羊和狼运到对岸的最小次数

     */
    public static int min = Integer.MAX_VALUE;
    // 羊的总数
    public static int countY;
    // 狼的总数
    public static int countL;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 羊的数量
        int m = sc.nextInt();
        // 狼的数量
        int n = sc.nextInt();
        // 小船可载的数量
        int x = sc.nextInt();

        countY = m;
        countL = n;

        // 求不损失羊的情况下，运输入几次

        guohe(m,n,x,0);

        if (min == Integer.MAX_VALUE){
            System.out.println(0);
        }else {
            System.out.println(min);
        }

    }

    /**
     *
     * @param m 岸边羊的数量
     * @param n 岸边狼的数量
     * @param x 船的承重
     * @param count 过河的次数
     */
    private static void guohe(int m, int n, int x, int count) {

        if (m + n <= x){
            min = Math.min(min,count + 1);
        }else {
            for (int i = 0; i <= m; i++){ // 过河的羊的个数
                for (int j = 0; j<=n; j++){ // 过河的狼的个数
                    if (i+j == 0 || i+j > x){
                        continue;
                    }
                    // 剩下的羊不为0的晴空下，必须比狼多
                    if (m- i != 0 && m-i <= n-j){
                        continue;
                    }
                    // 对岸的羊在不为0的情况下，要大于狼
                    if (countY - (m-i) != 0 && countY -(m-i) <= countL - (n-j)){
                        continue;
                    }
                    guohe(m-i,n-j,x,count+1);
                }
            }
        }

    }

}
