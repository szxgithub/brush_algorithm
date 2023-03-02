package od2023.onehundred;

import java.util.HashMap;
import java.util.Scanner;

public class Main35 {

    /*

    最多提取子串数目（挑选字符串）

    给定由a-z 26个英文小写字母组成的字符串A和B,其中A中可能存在重复字母，B中不会存在重复字母
    现从字符串A中按规则挑选一些字母，可以组成字符串B

    规则如下：
    1、同一个位置的字母只能挑选一次
    2、被挑选的字母相对先后顺序性不能改变

    求最多可同时从A中挑选多少组能组成B的字符串

    输入：
    ababcecfdc
    abc
    输出：
    2

     */

    /*
        推荐该方法
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String strF = sc.nextLine();    //父字符串
        String strS = sc.nextLine();    //子字符串

        char[] chars = strF.toCharArray();  //将父字符串转化为数组

        int indexF = 0;     //父字符串索引
        int indexS = 0;     //子字符串索引
        int count = 0;      //符合的个数
        while (indexF < strF.length()){
            if(chars[indexF] == strS.charAt(indexS)){
                chars[indexF] = ' ';    //已经匹配的置为空
                indexS++;
            }
            if(indexS == strS.length()){    //长度相同则表示符合子串
                indexS = 0;
                indexF = 0;
                count++;
            }else {
                indexF++;   //不符合则匹配下一个字符
            }
        }

        System.out.println(count);
    }



}
