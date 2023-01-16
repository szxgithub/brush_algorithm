package com.nowcoder;

/**
 * 统计每个月兔子的总数
 *
 * 描述
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问第n个月的兔子总数为多少？
 *
 * 本题有多组数据。
 *
 * 数据范围：每组输入满足 1 \le n \le 31 \1≤n≤31
 * 输入描述：
 * 多行输入，一行输入一个int型整数表示第n个月
 *
 * 输出描述：
 * 每一行输出对应的兔子总数
 */
import java.util.*;

public class Demo27 {
    // 备忘录，减少重叠子问题
    private static int[] memo;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int month = scanner.nextInt();
            // 备忘录里的元素都初始化为-1
            memo = new int[month + 1];
            Arrays.fill(memo, -1);
            System.out.println(dp(month));
        }

    }

    // 返回第n个月兔子总量
    private static int dp(int n) {
        // 递归终止条件
        if(n <= 2) {
            return 1;
        }
        // 使用备忘录
        if(memo[n] != -1) {
            return memo[n];
        }
        // 递归调用，满足规律
        memo[n] = dp(n - 1) + dp(n - 2);
        return memo[n];
    }
}

