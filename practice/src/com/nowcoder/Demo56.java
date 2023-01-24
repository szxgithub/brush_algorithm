package com.nowcoder;

/**
 *
 * 矩阵乘法
 *
 * 输入描述：
 * 输入包含多组数据，每组数据包含：
 * 第一行包含一个正整数x，代表第一个矩阵的行数
 * 第二行包含一个正整数y，代表第一个矩阵的列数和第二个矩阵的行数
 * 第三行包含一个正整数z，代表第二个矩阵的列数
 * 之后x行，每行y个整数，代表第一个矩阵的值
 * 之后y行，每行z个整数，代表第二个矩阵的值
 *
 * 输出描述：
 * 对于每组输入数据，输出x行，每行z个整数，代表两个矩阵相乘的结果
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
2
3
2
1 2 3
3 2 1
1 2
2 1
3 3
*/
public class Demo56 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            int x=Integer.parseInt(str);
            str = bf.readLine();
            int y=Integer.parseInt(str);
            str = bf.readLine();
            int z=Integer.parseInt(str);
            int[][] A=new int[x][y];
            int[][] B=new int[y][z];
            for (int i = 0; i < x; i++) {
                str = bf.readLine();
                String[] ax=str.split(" ");
                for (int j = 0; j < y; j++) {
                    A[i][j]=Integer.parseInt(ax[j]);
                }
            }
            for (int i = 0; i < y; i++) {
                str = bf.readLine();
                String[] ax=str.split(" ");
                for (int j = 0; j < z; j++) {
                    B[i][j]=Integer.parseInt(ax[j]);
                }
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    int t=0;
                    for (int j2 = 0; j2 <y; j2++) {
                        t+=A[i][j2]*B[j2][j];
                    }
                    ans.append(t).append(" ");;
                }
                ans.deleteCharAt(ans.length()-1).append("\n");
            }
            System.out.print(ans.toString());
        }
    }
}

