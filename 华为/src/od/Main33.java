package od;

import java.util.Scanner;

public class Main33 {

    /**
     *
     *
     * 敏感字段加密
     *
     * 输入
     * 1
     * pasword_a12345678__timeout_100
     * 输出
     * pasword_******_timeout_100
     *
     * 输入
     * 2
     * aaa_password_"a12_45678"_timeout__100_""_
     * 输出
     * aaa_password_******_timeout_100_""
     *
     *
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int k = Integer.valueOf(sc.nextLine());

        String str = sc.nextLine();

        int countPrefix = 0;
        int left = 0;
        int right = 0;
        boolean flag = false;
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '_' && str.charAt(i + 1) != '_'){
                if (str.charAt(i+1) == '"'){
                    flag = true;
                }
                countPrefix++;
                if (countPrefix == k){
                    left = i+1;
                    break;
                }
            }
        }

        for (int i =left; i < str.length(); i++){
            if (str.charAt(i) != '_' && str.charAt(i + 1) == '_'){
                if (flag){
                    if (str.charAt(i) == '"'){
                        right = i + 1;
                        break;
                    }
                }else {
                    right = i + 1;
                    break;
                }

            }
        }
        String s1 = str.substring(0, left).replaceAll("[_]+", "_");
        String s2 = str.substring(right).replaceAll("[_]+", "_");

        if (s1.startsWith("_")){
            s1 = s1.substring(1);
        }
        if (s2.endsWith("_")){
            s2 = s2.substring(0,s2.length()-1);
        }

        String s = s1 + "******" + s2;
        System.out.println(s);


    }

}
