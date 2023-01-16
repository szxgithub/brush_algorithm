package com.nowcoder;

/**
 *四则运算
 *
 *描述
 * 输入一个表达式（用字符串表示），求这个表达式的值。
 * 保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
 *
 * 数据范围：表达式计算结果和过程中满足 |val| \le 1000 \∣val∣≤1000  ，字符串长度满足 1 \le n \le 1000 \1≤n≤1000
 *
 * 输入描述：
 * 输入一个算术表达式
 *
 * 输出描述：
 * 得到计算结果
 */
import java.util.*;
import javax.script.*;

public class Demo37{
    public static void main(String[] args) throws ScriptException {
        Scanner scan = new  Scanner(System.in);
        String input = scan.nextLine();
        input = input.replace("[","(");
        input = input.replace("{","(");
        input = input.replace("}",")");
        input = input.replace("]",")");
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        System.out.println(scriptEngine.eval(input));
    }
}

/*

import java.util.Arrays;
import java.util.Scanner;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        int num1 = 0;
        int o1 = 1;
        int num2 = 1;
        int o2 = 1;
        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){  //遇到数字则定义num2
                int cur = 0;
                while(i<n && Character.isDigit(s.charAt(i))){
                    cur = cur * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                num2 = o2 == 1 ? num2 * cur : num2 / cur;
            }else if(c=='*' || c=='/'){  //遇到×÷定义o2
                o2 = c == '*' ? 1 : -1;
            }else if(c == '(' || c=='{' || c=='['){  //遇到括号则保存当前结果，并初始化
                stk.push(num1);
                stk.push(o1);
                stk.push(num2);
                stk.push(o2);

                num1 = 0;
                o1 = 1;
                num2 = 1;
                o2 = 1;
            }else if(c == '+' || c=='-'){  //遇到加减，说明可以开始计算，计算num1并对定义其他几个变量
                if(c=='-' && (i==0 || s.charAt(i-1)=='(' || s.charAt(i-1)=='[' || s.charAt(i-1)=='{')){
                    o1 = -1;
                    continue;
                }
                num1 = num1 + o1 * num2;
                o1 = (c == '+' ? 1 : -1);
                num2 = 1;
                o2 = 1;
            }else{  //遇到右括号，则出栈，并计算num2
                int cur = num1 + o1 * num2;
                o2 = stk.pop();
                num2 = stk.pop();
                o1 = stk.pop();
                num1 = stk.pop();

                num2 = o2 == 1 ? num2 * cur : num2 / cur;
            }
        }
        System.out.println(num1 + o1 * num2);
    }
}



 */

