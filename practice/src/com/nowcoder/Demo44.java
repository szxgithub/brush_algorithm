package com.nowcoder;

/**
 * 高精度整数加法
 *
 * 描述
 * 输入两个用字符串 str 表示的整数，求它们所表示的数之和。
 *
 * 本题含有多组样例输入。
 *
 * 数据范围： 1 \le len(str) \le 10000 \1≤len(str)≤10000
 * 输入描述：
 * 输入两个字符串。保证字符串只含有'0'~'9'字符
 */
import java.util.Scanner;
import java.math.BigInteger;

public class Demo44 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String s1 = scan.next();
            String s2 = scan.next(); //输入两个数
            BigInteger a = new BigInteger(s1); //将字符串转成大整数
            BigInteger b = new BigInteger(s2);
            System.out.println(a.add(b)); //大整数相加
        }
    }
}

