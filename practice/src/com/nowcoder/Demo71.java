package com.nowcoder;

/**
 *
 * 求最大连续bit数
 *
 * 描述
 * 求一个int类型数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 * 本题含有多组样例输入。
 *
 * 输入描述：
 * 输入一个int类型数字
 *
 * 输出描述：
 * 输出转成二进制之后连续1的个数
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Demo71 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            String binStr = Integer.toBinaryString(Integer.parseInt(str));
            String[] list = binStr.split("0");
            int n = 0;
            for(int i = 0; i < list.length; i++) {
                n = Math.max(n, list[i].length());
            }
            System.out.println(n);
        }
    }
}
