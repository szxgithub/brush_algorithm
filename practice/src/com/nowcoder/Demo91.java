package com.nowcoder;

/**
 *
 * 求最小公倍数
 *
 * 描述
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 *
 * 输入描述：
 * 输入两个正整数A和B。
 *
 * 输出描述：
 * 输出A和B的最小公倍数。
 *
 *
 */
import java.util.Scanner;

public class Demo91 {

    /*
    思路：
欧几里得求最大公约数，根据公式ab=最小公倍数 * gcd(a,b)，得到最小公倍数。
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        System.out.println(a*b/gcd(a,b));
    }

    private static int gcd(int a, int b) {
        // TODO Auto-generated method stub
        return b==0?a:gcd(b,a%b);
    }
}

