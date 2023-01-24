package nowcoder;

import java.util.Scanner;

public class HJ4 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){

            String str = sc.nextLine();

            for (int i = 0; i < str.length(); i+=8){

                if (i + 8 > str.length()){
                    String substring = str.substring(i, str.length());
                    for (int j = 0; j < i + 8 - str.length(); j++){
                        substring += "0";
                    }
                    System.out.println(substring);
                    break;
                }else {
                    String substring = str.substring(i, i + 8);
                    System.out.println(substring);
                }
            }

        }

    }

}
