package com.nowcoder;

/**
 *
 *  图片整理
 * 描述
 * Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过代码解决。
 *
 * 本题含有多组样例输入。
 *
 * 数据范围：每组输入的字符串长度满足   1≤n≤1000
 *
 * 输入描述：
 * Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024。
 *
 * 输出描述：
 * Lily的所有图片按照从小到大的顺序输出
 */
import java.util.Scanner;

public class Demo24{

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int a[]=new int[128];
            String str=in.next();
            for(int i=0;i<str.length();i++){
                int k=str.charAt(i);//统计出现次数
                a[k]++;
            }
            for(int j=48;j<a.length;j++){//从'0'开始输出
                if(a[j]!=0)
                    for(int b=0;b<a[j];b++)
                        System.out.print((char)j);
            }
            System.out.println();
        }
    }

}