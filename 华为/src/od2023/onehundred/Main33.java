package od2023.onehundred;

import java.util.Scanner;

public class Main33 {

    /*

    最左侧冗余覆盖子串（冗余覆盖）

    给定两个字符串s1 和 s2的正整数K, 其中s1长度为n1, s2长度为n2，在s2中选一个子串，满足：
    该子串长度为 n1 + k
    该子串中包含s1中全部字母
    该子串每个字母出现的次数不小于s1对应的字母


     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int k = sc.nextInt();

        int res = -1;
        int len = s1.length() + k;
        for (int i =0; i <s2.length(); i++){
            // 找子串
            char[] array = s2.substring(i, i + len).toCharArray();
            if (handle(s1,array)){
                res = i;
                break;
            }
        }

        System.out.println(res);

    }
    public static boolean handle(String str, char[] chars){
        int count =0;
        for (int i =0; i<str.length(); i++){
            for (int j =0; j<chars.length; j++){
                if (str.charAt(i) == chars[j]){
                    chars[j] = ' ';
                    count++;
                    break;
                }
            }
        }
        return count == str.length();
    }


}
