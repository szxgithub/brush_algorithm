package com.nowcoder;

/**
 *
 * 合唱队
 * 描述
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 *
 * 说明：
 *
 * N 位同学站成一排，音乐老师要请其中的 (N - K) 位同学出列，使得剩下的 K 位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为 1，2…，K ，他们的身高分别为 T1，T2，…，TK ，   则他们的身高满足存在 i （1<=i<=K） 使得 T1<T2<......<Ti-1<Ti>Ti+1>......>TK 。
 *
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形
 */
import java.io.*;
import java.util.*;

public class Demo14{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] arrL = new int[n]; // 左侧小于arr[i]的个数
            int[] arrR = new int[n]; // 右侧大于arr[i]的个数
            for(int i = 0; i < n; ++i){
                arr[i] = sc.nextInt();
            }

            for(int i = 0; i < n; ++i){
                arrL[i] = 0; // 所以默认初始是0,,对于第一个数来说， 在arr[0]的左侧小于arr[0]的个数是0。
                for(int j = 0; j < i; ++j){
                    if(arr[i] > arr[j]){
                        arrL[i] = Math.max(arrL[j] + 1, arrL[i]);
                    }
                }
            }

            for(int i = n - 1; i >= 0; --i){
                arrR[i] = 0; // 所以默认初始是0,,对于最后一个数来说， 在arr[n - 1]的右侧小于arr[0]的个数是0。
                for(int j = n - 1; j > i; --j){
                    if(arr[i] > arr[j]){
                        arrR[i] = Math.max(arrR[j] + 1, arrR[i]);
                    }
                }
            }

            int maxValue = 0;
            for(int i = 0; i < n; ++i){
                maxValue = Math.max(maxValue, arrR[i] + arrL[i] + 1);
            }

            System.out.println(n - maxValue);
        }
    }
}
