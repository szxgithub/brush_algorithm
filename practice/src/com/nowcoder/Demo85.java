package com.nowcoder;

/**
 *
 * 等差数列
 *
 * 描述
 * 等差数列 2，5，8，11，14。。。。
 * （从 2 开始的 3 为公差的等差数列）
 * 输出求等差数列前n项和
 *
 * 本题有多组输入
 *
 * 输入描述：
 * 输入一个正整数n。
 *
 * 输出描述：
 * 输出一个相加后的整数。
 */
import java.util.*;

public class Demo85 {

    private int sum(int n) {
        return (1 + 3*n) * n / 2;
    }

    public Demo85() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int res = sum(n);
            System.out.println(res);
        }
    }

    public static void main(String[] args) {
        Demo85 solution = new Demo85();
    }
}
