package com.nowcoder;

/**
 *
 * Redraiment的走法
 *
 * Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
 *
 * 输入描述：
 * 输入多组数据，1组有2行，第1行先输入数组的个数，第2行再输入梅花桩的高度
 *
 * 输出描述：
 * 一组输出一个结果
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HJ103
 * @author uyz
 * 20/09/08
 */
public class Demo88 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int num = Integer.parseInt(str);
            String[] strs = br.readLine().split(" ");
            int[] nums = new int[num];
            for(int i = 0; i < num; i++){
                nums[i] = Integer.parseInt(strs[i]);
            }
            System.out.println(jump(nums));
        }
    }

    public static Integer jump(int[] ints){
        int len = ints.length;
        int[] dp = new int[len];
        for(int i = 0; i < len; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(ints[j] < ints[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < len; i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}

