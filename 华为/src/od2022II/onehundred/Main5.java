package od2022II.onehundred;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main5 {

    /*

    求满足条件的最长子串的长度
    给定一个字符串，只含字母和数字，按要求找出字符串中最长子串的长度，字符串本身就是最长的子串
    子串要求：
        1、只含1个字母（a-z、A-Z），其余必须是数字
        2、字母可以在子串中的任意位置
     如果找不到满足要求的子串，则返回-1

    输入描述：
        字符串（只含数字和字母）
    输出描述：
        子串的长度

     */

    /*
    暴力解法
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int res = -1;
        for (int i = 0; i < str.length(); i++){
            for (int j = i + 2; j< str.length(); j++){
                String substring = str.substring(i, j);
                if (substring.replaceAll("[0-9]","").length() == 1){
                    res = substring.length() > res ? substring.length() : res;
                }
            }
        }
        System.out.println(res);
    }

    /*
    滑动窗口解法 待补充
     */
    public int getResult(String str){

        int maxLen = -1;

        int l = 0;
        int r = 0;

        // 在right指针扫描过程中，需要记录字母所在的索引
        LinkedList<Integer> letterIdx = new LinkedList<>();

        while (r <str.length()){
            char c = str.charAt(r);
            if (Character.isLetter(c)){
                letterIdx.add(r);
                if (letterIdx.size() > 1){
                    if (Character.isLetter(str.charAt(l))){
                        l++;
                        letterIdx.removeFirst();
                    }else {
                        l = letterIdx.removeFirst() + 1;
                    }
                }
            }else {
                maxLen = Math.max(maxLen,r - l + 1);
            }

            r++;
        }

        return maxLen;
    }

}
