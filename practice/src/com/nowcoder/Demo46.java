package com.nowcoder;

/**
 *
 * 找出字符串中第一个只出现一次的字符
 *描述
 * 找出字符串中第一个只出现一次的字符
 * 输入描述：
 * 输入几个非空字符串
 *
 * 输出描述：
 * 输出第一个只出现一次的字符，如果不存在输出-1
 */
import java.util.*;

public class Demo46
{
    private int count(String str)
    {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : str.toCharArray()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return -1;
    }

    public Demo46()
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine())
        {
            String str = in.nextLine();
            int result = count(str);
            if (result == -1) {
                System.out.println(result);
            }
            else {
                System.out.println((char)result);
            }
        }
    }

    public static void main(String[] args)
    {
        Demo46 solution = new Demo46();
    }
}
