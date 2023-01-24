package com.nowcoder;

/**
 * 简单密码
 *
 */
import java.io.*;

public class Demo11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            //获取第i个字符
            char c = str.charAt(i);
            //判断，处理
            if (c >= 'A' && c < 'Z') {
                c = (char) (c + 'b' - 'A');
            } else if (c == 'Z') {
                c = 'a';
            } else if (c>='a' && c<='c') {
                c = '2';
            } else if (c>='d' && c<='f') {
                c = '3';
            } else if (c>='g' && c<='i') {
                c = '4';
            } else if (c>='j' && c<='l') {
                c = '5';
            } else if (c>='m' && c<='o') {
                c = '6';
            } else if (c>='p' && c<='s') {
                c = '7';
            } else if (c>='t' && c<='v') {
                c = '8';
            } else if (c>='w' && c<='z') {
                c = '9';
            }
            sb.append(c);
        }
        System.out.println(sb.toString().trim());
    }
}