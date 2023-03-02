package od2023.onehundred;

import java.util.Scanner;

public class Main63 {

    /*

    递增字符串
    定义字符串完全由‘A'和'B’组成，当然也可也全是A或B，如果字符串从前往后都是以字典序排列的，
    如果字符串从前往后都是以字典序排列，称之为“严格递增”

    给出一个字符串s，允许修改任意字符，求使s满足严格递增的最小修改次数


     */

    /*

    动态规划 若博豆题解

     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();

        int min = 0;
        int countB = 0;

        for (int i = 0; i < string.length(); i++) {

            if (string.charAt(i) == 'B'){
                //假设之前的子字符串经过修改已满足要求，当前位置的B并不会使字典序变化，只统计B的个数
                countB ++;
            }
            if (string.charAt(i) == 'A') {
                //方案1 : 把所有之前的B改为A
                int candidate1 = countB;

                //方案2：假设在当前位置以前的子字符串经过修改已满足要求，把当前位置的A改为B,即动态编程思想
                int candidate2 = min + 1;

                min = Math.min( candidate1, candidate2);
            }
        }

        System.out.println(min);
    }

    /*
    动态规划
     */
    public static int getResult(String str){
        int total = str.length();
        int A = str.replaceAll("B","").length();

        if (A == 0 || A == total){
            return 0;
        }

        // 修改为全A 或者全B的修改次数取最小
        int ans = Math.min(A,total - A);
        int leftA = 0;
        for (int i = 0; i<total; i++){
            if (str.charAt(i) == 'A'){
                leftA++;
            }

            //一共需要修改 i+1 - dp[i] + A- dp[i] 次  使用leftA变量替代dp数组
            ans = Math.min(i + 1 - leftA + A - leftA,ans);
        }

        return ans;
    }


}
