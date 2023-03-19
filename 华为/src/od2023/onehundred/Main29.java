package od2023.onehundred;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main29 {

    /*
    分界线(匿名信)

    只需要满足每个单词中字母数量一致即可，不关注每个字母的顺序，求报纸内容是否可以拼成匿名信

    输入描述：
        第一行输入newspaper内容，包括1-N个字符串，用空格分开
        第二行输入anonymousLetter内容，包括1-N个字符串，用空格分开

    输出描述：
        如果报纸可以拼成匿名信，返回true, 否则返回false

     */

    /*
    逻辑分析
    推荐这种解法， 利用一个map统计报纸中单词的个数
    时间复杂度O(n)
     */
    public static boolean getResult(String[] newspaper, String[] anonymousLetter) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String str : newspaper) {
            String newStr = strSort(str);
            count.put(newStr, count.getOrDefault(newStr, 0) + 1);
        }

        boolean flag = true;
        for (String str : anonymousLetter) {
            String newStr = strSort(str);

            if (count.containsKey(newStr) && count.get(newStr) > 0) {
                count.put(newStr, count.get(newStr) - 1);
            } else {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public static String strSort(String str) {
        char[] cArr = str.toCharArray();
        Arrays.sort(cArr);
        return new String(cArr);
    }



}
