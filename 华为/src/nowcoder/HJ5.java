package nowcoder;

import java.util.Scanner;

public class HJ5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){

            String str = sc.nextLine();

            String substring = str.substring(2, str.length());

            int i = Integer.parseInt(substring, 16);

            System.out.println(i);
        }


    }

}
