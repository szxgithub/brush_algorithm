package com.nowcoder;

/**
 *
 * 在字符串中找出连续最长的数字串
 *
 *
 */
import java.util.*;

public class Demo77 {

    public Demo77() {
    }

    public int continumax(List<String> pOutputstr,  String intputstr) {
        int max = 0 ;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < intputstr.length(); i++) {
            // 找出连续最长数字串
            if (intputstr.charAt(i) >= '0' && intputstr.charAt(i) <= '9') {
                while (i < intputstr.length() && intputstr.charAt(i) >= '0' && intputstr.charAt(i) <= '9') {
                    s.append(intputstr.charAt(i++));
                }
                max = Math.max(max, s.length());
                pOutputstr.add(s.toString());
                s.setLength(0);
            }
        }
        // 移除短的数字串
        for (int i = 0; i < pOutputstr.size(); i++) {
            if (pOutputstr.get(i).length() < max) {
                pOutputstr.remove(i);
                i--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Demo77 solution = new Demo77();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String pInStr = in.nextLine();
            List<String> pOutputstr = new LinkedList<>();
            int res = solution.continumax(pOutputstr, pInStr);
            for (String str : pOutputstr) {
                System.out.print(str);
            }
            System.out.println("," + res);
        }

    }
}
