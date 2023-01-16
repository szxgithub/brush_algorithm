package com.nowcoder;

/**
 *
 * 矩阵乘法计算量估算
 *
 * 输入描述：
 * 输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，最后输入要计算的法则
 * 计算的法则为一个字符串，仅由左右括号和大写字母（'A'~'Z'）组成，保证括号是匹配的且输入合法！
 *
 * 输出描述：
 * 输出需要进行的乘法次数
 */
import java.io.*;
import java.util.Stack;

public class Demo57{
    public static void main(String[] args)throws Exception{
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input=buff.readLine())!= null){
            int num = Integer.parseInt(input);
            int[][] arr = new int[num][2];
            for(int i = 0 ; i < num ; i++){
                String [] sa = buff.readLine().split(" ");
                arr[i][0] = Integer.parseInt(sa[0]);
                arr[i][1] = Integer.parseInt(sa[1]);
            }
            int sum = 0;
            int n = arr.length -1;
            Stack<Integer> stack = new Stack<>();
            char[] ca = buff.readLine().toCharArray();
            for(int i = ca.length-1 ; i >= 0 ; i--){
                char a = ca[i];
                if(a == ')'){
                }else if(a == '('){
                    int n1 = stack.pop();
                    int n2 = stack.pop();
                    sum += arr[n1][0]*arr[n2][0]*arr[n2][1];
                    arr[n1][1] = arr[n2][1];
                    stack.push(n1);
                }else{
                    stack.push(n);
                    n--;
                }
            }
            System.out.println(sum);
        }
    }
}
