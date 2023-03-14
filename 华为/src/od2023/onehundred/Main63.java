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
        // 不适用dp数组，使用leftA变量，因为数组最长可能很长，容易爆内存
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
