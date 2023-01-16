package com.nowcoder;

/*
删除字符中出现次数最少的字符
 */
import java.util.*;

public class Demo13 {

    public Demo13() {
    }

    public String delete(String str) {
        // Map记录每个字母的次数
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // 快速找出最少次数
        int min = Integer.MAX_VALUE;
        for (int times : map.values()) {
            min = Math.min(min, times);
        }
        StringBuilder res = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (map.get(ch) != min) {
                res.append(ch);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Demo13 solution = new Demo13();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String res = solution.delete(str);
            System.out.println(res);
        }
    }
}
