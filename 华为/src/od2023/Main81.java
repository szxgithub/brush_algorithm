package od2023;

import java.util.Arrays;
import java.util.Scanner;

public class Main81 {

    /*
    分界线
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 报纸上的
        String str1 = sc.nextLine();
        // 匿名信的
        String str2 = sc.nextLine();

        String[] s1 = str1.split(" ");
        String[] s2 = str2.split(" ");

        int count = 0;
        for (int i = 0; i<s2.length; i++){
            char[] chars2 = s2[i].toCharArray();
            Arrays.sort(chars2);
            String tmpS2 = Arrays.toString(chars2);
            for (int j = 0; j <s1.length; j++){
                char[] chars1 = s1[j].toCharArray();
                if (chars1.length != chars2.length){
                    continue;
                }else {
                    Arrays.sort(chars1);
                    String tmpS1 = Arrays.toString(chars1);
                    if (tmpS2.equals(tmpS1)){
                        count++;
                        break;
                    }
                }
            }
        }

        if (count == s2.length){
            System.out.println(true);
        }else {
            System.out.println(false);
        }

    }


}
