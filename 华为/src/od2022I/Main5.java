package od2022I;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {

        /***
         *
         * 相对开音节
         *
         * 输入：
         *  字符串，以空格分割的多个单词  字符串长度<10000,
         *
         * 输出：
         *  含有相对开音结构的子串个数
         *
         * 示例：
         *  输入：ekam a ekac
         *  输出：2
         *
         *  !ekam a ekekac
         *  2
         *
         *
         */

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            String str = sc.nextLine();

            String[] wordArray = str.split(" ");

            List<String> list = new ArrayList<>();
            for (int i = 0; i< wordArray.length; i++){
                boolean flag = onlyContainLetter(wordArray[i]);
                if (flag){
                    StringBuilder sb = new StringBuilder(wordArray[i]);
                    list.add(sb.reverse().toString());
                }
            }

            // 判断哪些是开音节子串
            int count = 0;
            for (int i = 0; i < list.size(); i++){
                String s = list.get(i);
                s = s.toLowerCase();
                for (int j = 0; j < s.length()-3; j++){
                    char c1 = s.charAt(j);
                    char c2 = s.charAt(j + 1);
                    char c3 = s.charAt(j + 2);
                    char c4 = s.charAt(j + 3);

                    if (
                            (c1 != 'a' && c1 != 'e' && c1 != 'i' && c1 != 'o' && c1 != 'u') &&
                            (c2 == 'a' || c2 == 'e' || c2 == 'i' || c2 == 'o' || c2 == 'u') &&
                            (c3 != 'a' && c3 != 'e' && c3 != 'i' && c3 != 'o' && c3 != 'u' && c3 != 'r') &&
                                    (c4 == 'e')

                    ){
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

    }

    private static boolean onlyContainLetter(String s) {

        char[] chars = s.toCharArray();
        for (int i = 0; i< chars.length; i++){
            if(!Character.isLetter(chars[i])){
                return false;
            }
        }
        return true;
    }

}
