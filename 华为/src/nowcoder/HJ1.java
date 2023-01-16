package nowcoder;

import java.util.Scanner;

public class HJ1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] s = str.split(" ");

        int length = s[s.length - 1].length();

        System.out.println(length);

    }

}
