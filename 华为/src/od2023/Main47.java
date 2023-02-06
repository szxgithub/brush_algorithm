package od2023;

import java.util.HashMap;
import java.util.Scanner;

public class Main47 {

    /*

    最多提取子串数目

    输入：
    ababcecfdc
    abc
    输出：
    2

     */

    public static void main2(String[] args) {

        Scanner sc = new Scanner(System.in);

        String A = sc.nextLine();
        String B = sc.nextLine();
        HashMap<Character,Integer> valid = new HashMap<>();
        for (int i = 0; i<B.length(); i++){
            valid.put(B.charAt(i),valid.getOrDefault(B.charAt(i),0)+1);
        }

        StringBuffer sb = new StringBuffer(A);
        int start = 0;
        int res = 0;
        HashMap<Character,Integer> window = new HashMap<>();
        for (int i = 0; i<sb.length(); i++){
            for (int j = start; j<B.length(); j++){
                if (sb.charAt(i) == B.charAt(j)){
                    window.put(sb.charAt(i),window.getOrDefault(sb.charAt(i),0) + 1);
                    sb.deleteCharAt(i);
                    i = -1;
                    j++;
                    start = j;
                    break;
                }else {
                    break;
                }
            }
            if (window.size() == valid.size()){
                res++;
                start = 0;
                window.clear();
            }
        }


        System.out.println(res);

    }


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
