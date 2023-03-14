package od2023.onehundred;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main58 {


    /*
    区块链文件转储系统
    区块链底层是一个链式文件系统，平台考虑将区块链按文件转存储到廉价的SATA盘，
    只有连续的区块链文件才能转存储到SATA盘上，且转储文件之和不能超过SATA的容量

    假设每块SATA盘容量为M，求能转储的最大连续文件之和

    输入描述：
        SATA盘的容量M
        区块链文件大小序列F1,F2,F3...Fn

    输出描述：
        求能转储的最大连续文件大小之和

输入：
1000
100 300 500 400 400 150 100
输出：
950


     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // SATA硬盘容量
        int M = sc.nextInt();
        sc.nextLine();

        String[] s = sc.nextLine().split(" ");
        int[] ints = Arrays.stream(s).mapToInt(value -> Integer.valueOf(value)).toArray();

        // 求最大子序列和 且和不超过容量M

        int result = getResult(ints, M);
        System.out.println(result);

    }

    /*
    滑动窗口 + 双指针解法
     */
    public static int getResult( int[] arr, int m){

        int l = 0, r = 0;
        int sum = 0, max = 0;

        while (r < arr.length){
            int newSum = sum + arr[r];
            if (newSum > m){
                sum -= arr[l];
                l++;
            }else if (newSum < m){
                sum += arr[r];
                r++;
                max = Math.max(sum,max);
            }else {
                return m;
            }
        }

        return max;
    }

}
