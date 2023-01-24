package com.nowcoder;

/**
 *
 * 字符逆序
 *
 * 描述
 * 将一个字符串str的内容颠倒过来，并输出。
 *
 * 输入描述：
 * 输入一个字符串，可以有空格
 *
 * 输出描述：
 * 输出逆序的字符串
 */
import java.util.*;

public class Demo89 {

    private String reverse(String str) {
        StringBuilder res = new StringBuilder(str);
        return res.reverse().toString();
    }

    public Demo89() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String res = reverse(str);
            System.out.println(res);
        }
    }

    public static void main(String[] args)
    {
        Demo89 solution = new Demo89();
    }
}
