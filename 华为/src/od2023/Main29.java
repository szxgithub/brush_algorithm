package od2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main29 {

    /*

    知识图谱新词挖掘1

    输入：
    qweebaewqd
    qwe
    输出： 2

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String content = sc.nextLine();
        String word = sc.nextLine();

        // 在conten找出word字符组成的目标字串

        char[] charWord = word.toCharArray();
        Arrays.sort(charWord);

        int left = 0;
        int right = word.length();
        int count =0;

        while (right <= content.length()){
            String temp = content.substring(left,right);
            char[] charTemp = temp.toCharArray();

            Arrays.sort(charTemp);

            boolean isTrue = true;
            for (int i = 0; i < charTemp.length; i++){
                if (charWord[i] != charTemp[i]){
                    isTrue = false;
                }
            }
            if (isTrue){
                count++;
            }
            left++;
            right++;
        }

        System.out.println(count);

    }

}
