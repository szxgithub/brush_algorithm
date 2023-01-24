package com.nowcoder;

/**
 *
 * 截取字符串
 *
 * 描述
 * 输入一个字符串和一个整数 k ，截取字符串的前k个字符并输出
 *
 * 本题输入含有多组数据

 * 输入描述：
 * 1.输入待截取的字符串
 *
 * 2.输入一个正整数k，代表截取的长度
 *
 * 输出描述：
 * 截取后的字符串
 */
import java.util.Scanner;

public class Demo35 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = null;
        String output = null;
        int end=0;
        String tmp=null;
        while (in.hasNext()) {
            input=in.nextLine();
            //end = in.nextInt();
            //此处不能使用nextInt方法,迭代器后移一位会导致下次运行时出现类型转换失败或者空指针异常
            tmp = in.nextLine();
            end=Integer.valueOf(tmp);
            output=input.substring(0,end);
            System.out.println(output);
        }
    }
}
