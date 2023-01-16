package nowcoder;

import java.util.Scanner;

public class HJ2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str1 = null;
        String str2 = null;
        while (sc.hasNextLine()){
            str1 = sc.nextLine();
            str2 = sc.nextLine();

            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();

            int count = 0;
            for (int i = 0; i < str1.length(); i++){
                String s = str1.charAt(i) + "";
                if (s.equals(str2)){
                    count++;
                }
            }

            System.out.println(count);
        }
    }

}
