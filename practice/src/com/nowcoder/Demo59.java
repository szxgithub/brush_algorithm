package com.nowcoder;

/**
 *
 *  百钱买百鸡问题
 *
 *  描述
 * 公元五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 * 现要求你打印出所有花一百元买一百只鸡的方式。
 * 输入描述：
 * 本题多组案例，对每一组案例输入任何一个整数，即可运行程序。
 *
 * 输出描述：
 *  输出有数行，每行三个整数，分别代表鸡翁，母鸡，鸡雏的数量
 */
import java.util.Scanner;

public class Demo59{
    public static void main(String[] args){
        for(int x = 0; x<= 20 ; x ++){
            for(int y = 0; y<= 33; y++){
                int z = 100-x-y;
                if(z%3==0 && 5*x+3*y+z/3 ==100 && x+y+z == 100){
                    System.out.println(x+" "+y+" "+z+" ");
                }
            }
        }
    }
}
