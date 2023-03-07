package od2022II.onehundred;

import java.util.HashMap;
import java.util.Scanner;

public class Main5_1 {

    /*

    寻找符合要求的最长子串
    给定一个字符串s，找出这样一个子串：
        该子串中的任意一个字符最多出现2次
        该子串不包含指定某个字符
    请你找出满足该条件的最长子串的长度

    输入描述：
        第一行，指定不包含的字符，为单个字符
        第二行，字符串s

     输入：
        D
        ABC123
    输出：6

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        // 指定字符
        char target = str.charAt(0);

        String s = sc.nextLine();


        int right = 0;
        int left = 0;
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while (right < s.length()){
            char c = s.charAt(right);
            if (c == target){
                max = Math.max(max,right-left);
                right++;
                left = right;
                continue;
            }
            if (map.containsKey(c)){
                if (map.get(c) >= 2){
                    max = Math.max(max,right-left);
                    if (map.containsKey(s.charAt(left))){
                        map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)-1);
                    }
                    left++;
                }else {
                    map.put(c,map.get(c) + 1);
                    right++;
                }
            }else {
                map.put(c,map.getOrDefault(c,0) + 1);
                right++;
            }
            if (right == s.length()){
                max = Math.max(max,right-left);
            }
        }

        System.out.println(max);

    }

}
