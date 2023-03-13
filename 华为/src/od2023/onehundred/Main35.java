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
       逻辑分析，该方法时间复杂度不是最优的
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

    /**
     *推荐该方法
     * 逻辑分析
     *
     * 要求从字符串a中挑选能组成字符串b的字符串，最多能同时挑选多少
     * @param a
     * @param b
     * @return
     */
    public int getResult(String a, String b){
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <b.length(); i++){
            char c = b.charAt(i);
            map.put(c,i);
        }

        // count对象记录遍历字符串a的过程中，统计到符合顺序要求的b字符串中字符的出现的次数
        int[] count = new int[b.length()];
        for (int i = 0; i < a.length(); i++){
            char c = a.charAt(i);
            if (map.containsKey(c)){
                Integer index = map.get(c);
                if (index == 0 || count[index] < count[index - 1]){
                    count[index]++;
                }
            }
        }

        return count[count.length - 1];
    }



}
