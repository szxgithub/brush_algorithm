package com.nowcoder;

/**
 *
 *  求小球落地5次后所经历的路程和第5次反弹的高度
 *
 *  描述
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 *
 * 最后的误差判断是小数点6位
 *
 *
 * 数据范围：输入的小球初始高度满足 1 \le n \le 1000 \1≤n≤1000  ，且保证是一个整数
 *
 * 输入描述：
 * 输入起始高度，int型
 *
 * 输出描述：
 * 分别输出第5次落地时，共经过多少米第5次反弹多高
 */
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Demo28 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            System.out.println(a*(1+2*Math.pow(0.5,1)+2*Math.pow(0.5,2)+2*Math.pow(0.5,3)+2*Math.pow(0.5,4)));
            System.out.println(a*Math.pow(0.5,5));
        }
    }
}

