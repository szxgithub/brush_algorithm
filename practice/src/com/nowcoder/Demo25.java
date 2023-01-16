package com.nowcoder;

import java.util.Scanner;

/**
 * 蛇形矩阵
 *
 * 描述
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 *
 * 例如，当输入5时，应该输出的三角形为：
 *
 * 1 3 6 10 15
 *
 * 2 5 9 14
 *
 * 4 8 13
 *
 * 7 12
 *
 * 11
 *
 *
 * 请注意本题含有多组样例输入。
 *
 * 输入描述：
 * 输入正整数N（N不大于100）
 *
 * 输出描述：
 * 输出一个N行的蛇形矩阵。
 */
public class Demo25 {
    public static void main(String args[]){//主方法，主要就是接收数据
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int num=sc.nextInt();
            printtriangle(num);
        }
    }

    public static void printtriangle(int num){ //输出方法输出蛇形矩阵
        int y=1;//列的方向第一个肯定是1
        int yCount=1;//列由上往下是等差数列，第一行和第二行差1
        for(int i=1;i<=num;i++){//行的循环次数
            int x=y;//第i行的第一个数就是列的第i个数
            int xCount=i+1; //可以看到第i行第一个加数刚好是i+1
            for(int j=1;j<=num-i+1;j++){ //列的循环次数，每次少一列
                System.out.print(x+" ");//循环输出x
                x+=xCount++;    //等差数列每次+1
            }
            System.out.println("");//换行
            y+=yCount++; //等差数列每次加1
        }
    }
}

/*

 public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine())!=null){
            int num = Integer.parseInt(str);
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= num; i++){
                int start = (i - 1) * i / 2 + 1;
                int step = i + 1;
                for(int j = 1; j <= num - i + 1; j++){
                    sb.append(start).append(" ");
                    start += step;
                    step ++ ;
                }
                sb.setCharAt(sb.length()-1,'\n');
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }

 */

