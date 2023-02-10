package od2023;

import java.util.Scanner;

public class Main86 {

    /*
        查找重复代码

        最长公共子串


        输入：
        private_void_method
        public_void_method
        输出：_void_method
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();


        StringBuffer sb = new StringBuffer();
        String res = "";
        int max = Integer.MIN_VALUE;
        for (int i =0; i < str1.length(); i++){
            for (int j = i+2;  j<str2.length()+1; j++){
                String substring = str2.substring(i, j);
                if (str1.contains(substring)){
                    if (substring.length() > max){
                        max = substring.length();
                        res = substring;
                    }
                }
            }
        }

        System.out.println(res);
    }

}
