package com.nowcoder;

/**
 *
 * 二维数组操作
 *
 * 输入描述：
 * 输入数据按下列顺序输入：
 * 1 表格的行列值
 * 2 要交换的两个单元格的行列值
 * 3 输入要插入的行的数值
 * 4 输入要插入的列的数值
 * 5 输入要查询的单元格的坐标
 *
 * 输出描述：
 * 输出按下列顺序输出：
 * 1 初始化表格是否成功，若成功则返回0， 否则返回-1
 * 2 输出交换单元格是否成功
 * 3 输出插入行是否成功
 * 4 输出插入列是否成功
 * 5 输出查询单元格数据是否成功
 */
import java.io.*;
public class Demo68{
    public static void main(String[] args)throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String input=null;
        while((input=reader.readLine())!=null){
            String[] s=input.split(" ");
            int r=Integer.parseInt(s[0]);//行
            int c=Integer.parseInt(s[1]);//列
            if(c>=0&&c<=9&&r>=0&&r<=9){//要求1的筛选
                System.out.println(0);
            }else {
                System.out.println(-1);
            }
            s=reader.readLine().split(" ");
            int r1=Integer.parseInt(s[0]);
            int c1=Integer.parseInt(s[1]);
            int r2=Integer.parseInt(s[2]);
            int c2=Integer.parseInt(s[3]);
            if(c1>=0&&c1<c && r1>=0&&r1<r && c2>=0&&c2<c &&r2>=0&&r2<r){
                System.out.println(0);
            }else{
                System.out.println(-1);
            }
            int ir=Integer.parseInt(reader.readLine());//输入要插入的行的数值
            int ic=Integer.parseInt(reader.readLine());//输入要插入的列的数值
            if(ir>=0&&ir<r&&(r+1)<=9)System.out.println(0);
            else System.out.println(-1);
            if(ic>=0&&ic<c&&(c+1)<=9)System.out.println(0);
            else System.out.println(-1);
            s=reader.readLine().split(" ");
            int qr=Integer.parseInt(s[0]);
            int qc=Integer.parseInt(s[1]);
            if(qr>=0&&qr<r&&qc>=0&&qc<c)System.out.println(0);
            else System.out.println(-1);
        }
    }
}