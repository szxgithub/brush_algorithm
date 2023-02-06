package od2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main50 {

    /*

    最左侧冗余覆盖子串

     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int k = sc.nextInt();

        int res = -1;
        int len = s1.length() + k;
        for (int i =0; i <s2.length(); i++){
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
