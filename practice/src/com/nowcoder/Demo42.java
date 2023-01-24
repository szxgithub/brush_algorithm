package com.nowcoder;

/**
 *
 *  挑7
 *  描述
 * 输出小于等于 n 的与 7 有关数字的个数，包括 7 的倍数，还有包含 7 的数字（如 17 ，27 ，37 ... 70 ，71 ，72 ，73...）的个数（一组测试用例里可能有多组数据，请注意处理）
 *
 * 数据范围： 1 \le n \le 30000 \1≤n≤30000
 */
import java.util.*;

public class Demo42 {

    public Demo42() {
    }

    private boolean conatins7(int n) {
        while (n != 0) {
            if (n % 10 == 7) return true;
            n /= 10;
        }
        return false;
    }

    public int count(int n) {
        int count = 0;
        for (int i = 7; i <= n; i++) {
            if (i % 7 == 0 || conatins7(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Demo42 solution = new Demo42();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = Integer.parseInt(in.next());
            int res = solution.count(n);
            System.out.println(res);
        }
    }
}
