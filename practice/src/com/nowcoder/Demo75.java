package com.nowcoder;

/**
 *
 * 合法IP
 *
 * 描述
 * IPV4地址可以用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位，表示成一个无符号整数（因此正号不需要出现），如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。
 *
 * 现在需要你用程序来判断IP是否合法。
 *
 *
 输入描述：
 输入一个ip地址，保证不包含空格

 输出描述：
 返回判断的结果YES or NO
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author eagle2020
 * @date 2021/9/29
 */
public class Demo75 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            String[] s = str.split("\\.");
            boolean flag = true;
            if (s.length == 4) {
                for (String s1 : s) {
                    try {
                        int i = Integer.parseInt(s1);
                        if(i < 0 || i > 255){
                            flag = false;
                            break;
                        }
                    } catch (NumberFormatException err) {
                        flag = false;
                        break;
                    }
                }
            }else{
                flag = false;
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }
}






