package com.nowcoder;

/**
 *
 *  输入n个整数，输出其中最小的k个
 *
 *  描述
 * 输入n个整数，输出其中最小的k个整数并按升序输出
 *
 * 本题有多组输入样例
 *
 * 数据范围：1 \le n \le 1000 \1≤n≤1000  ，输入的整数满足 1 \le val \le 10000 \1≤val≤10000
 * 输入描述：
 * 第一行输入两个整数n和k
 * 第二行输入一个整数数组
 *
 * 输出描述：
 * 输出一个从小到大排序的整数数组
 */
import java.util.*;

public class Demo45 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            for(int i=0;i<k;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}
