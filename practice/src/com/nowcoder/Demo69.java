package com.nowcoder;

/**
 *
 * 统计大写字母个数
 *
 * 输入描述：
 * 本题含有多组样例输入
 * 对于每组样例，输入一行，代表待统计的字符串
 *
 * 输出描述：
 * 对于每组样例，输出一个整数，代表字符串中大写字母的个数
 */
import java.util.*;

public class Demo69 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String s = input.nextLine();
            System.out.println(count(s));
        }
    }
    public static int count(String s){
        int count=0;
        char[] cs=s.toCharArray();
        for(char c:cs){
            if(c>='A' && c<='Z'){
                count++;
            }
        }
        return count;
    }
}
