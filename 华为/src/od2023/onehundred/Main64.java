package od2023.onehundred;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main64 {

    /*

    单词倒序

    输入：yM eman si boB.
    输出：My name is Bob.

    输入：woh era uoy ? I ma enif.
    输出：how are you? I am fine.
     */

    /*
    逻辑分析
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] s = str.split(" ");
        for (int i =0; i<s.length; i++){
            if (s[i].equals(",") || s[i].equals(".") || s[i].equals("?")){
                continue;
            }

            if (s[i].endsWith(",") || s[i].endsWith(".") || s[i].endsWith("?")){
                String tmp = s[i].substring(0, s[i].length() - 1);
                StringBuffer sb = new StringBuffer(tmp);
                sb.reverse();
                sb.append(s[i].charAt(s[i].length()-1));
                s[i] = sb.toString();
                continue;
            }

            StringBuffer sb = new StringBuffer(s[i]);
            sb.reverse();
            s[i] = sb.toString();
        }

        String collect = Arrays.stream(s).collect(Collectors.joining(" "));
        System.out.println(collect);
    }

}
