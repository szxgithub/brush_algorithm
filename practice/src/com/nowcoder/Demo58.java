package com.nowcoder;

/**
 *字符串通配符
 *输入描述：
 * 先输入一个带有通配符的字符串，再输入一个需要匹配的字符串
 *
 * 输出描述：
 * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Demo58 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String regex;
        while ((regex = br.readLine()) != null) {
            regex = regex.toLowerCase();
            String content = br.readLine().toLowerCase();
            boolean[][] array = new boolean[regex.length() + 1][content.length() + 1];
            array[0][0] = true;
            if(regex.charAt(0) == '*') {
                array[1][0] = true;
            }
            for(int i = 1;i <= regex.length();i++) {
                char ch = regex.charAt(i - 1);
                for(int j = 1;j <= content.length();j++) {
                    char c = content.charAt(j - 1);
                    if(ch == '?') {
                        if(check(c)) {
                            array[i][j] = array[i - 1][j - 1];
                        } else {
                            array[i][j] = false;
                        }
                    } else if(ch == '*') {
                        if(check(c)) {
                            array[i][j] = array[i - 1][j - 1] || array[i - 1][j] || array[i][j - 1];
                        } else {
                            array[i][j] = false;
                        }
                    } else if(ch == c) {
                        array[i][j] = array[i - 1][j - 1];
                    } else {
                        array[i][j] = false;
                    }
                }
            }
            System.out.println(array[regex.length()][content.length()]);
        }
    }

    public static boolean check(char ch) {
        if (ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }

}


