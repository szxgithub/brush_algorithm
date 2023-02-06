package od2023;

import java.util.Scanner;

public class Main42 {

    /*
    机房布局


     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();


        int ans = 0;
        for (int i =0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'M'){
                if (i + 1 < str.length() && str.charAt(i+1) == 'I'){
                    ans++;
                    i+=2;
                }else if (i-1 >= 0 && str.charAt(i-1) == 'I'){
                    ans++;
                }else {
                    ans = -1;
                    break;
                }
            }

        }

        System.out.println(ans);

    }



}
