package com.nowcoder;

/**
 *
 *  整型数组合并
 *
 *  描述
 * 题目标题：
 *
 * 将两个整型数组按照升序合并，并且过滤掉重复数组元素。
 * 输出时相邻两数之间没有空格。
 * 请注意本题有多组样例。
 *
 *
 *
 * 输入描述：
 * 输入说明，按下列顺序输入：
 * 1 输入第一个数组的个数
 * 2 输入第一个数组的数值
 * 3 输入第二个数组的个数
 * 4 输入第二个数组的数值
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 数组合并
 *
 * @author zqfly
 *
 */
public class Demo65 {

    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str="";
        while((str=br.readLine())!=null){
            int a=Integer.parseInt(str);
            String[] s1=br.readLine().split(" ");
            int b=Integer.parseInt(br.readLine());
            String[] s2=br.readLine().split(" ");
            int[] aa=new int[s1.length+s2.length];
            for(int i=0;i<s1.length;i++){
                aa[i]=Integer.parseInt(s1[i]);
            }
            for(int i=0;i<s2.length;i++){
                aa[i+s1.length]=Integer.parseInt(s2[i]);
            }
            Arrays.sort(aa);
            StringBuilder sb = new StringBuilder();
            sb.append(aa[0]);
            for(int i=1;i<aa.length;i++){
                if(aa[i]!=aa[i-1]){
                    sb.append(aa[i]);
                }
            }
            System.out.println(sb.toString());
        }
    }

}

