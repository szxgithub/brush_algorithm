package od2023.onehundred;

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


     */

    /*
    采用 双指针 + 滑动窗口解法
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // SATA硬盘容量
        int M = sc.nextInt();
        sc.nextLine();

        String[] s = sc.nextLine().split(" ");
        int[] ints = Arrays.stream(s).mapToInt(value -> Integer.valueOf(value)).toArray();

        // 求最大子序列和 且和不超过容量M
        int left = 0;
        int right = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        while (max != M && (right < ints.length || sum > max)){
            if (sum <= M){
                max = Math.max(max,sum);
                if (right < ints.length){
                    sum += ints[right];
                    right++;
                }
            }else {
                sum -= ints[left];
                left++;
            }
        }

        System.out.println(max);

    }

}
