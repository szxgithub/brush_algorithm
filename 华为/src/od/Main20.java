package od;

import java.util.Scanner;

public class Main20 {


    /**
     *
     * 拼接URL
     *
     *
     *
     * */


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){

            String str = sc.nextLine();

            String[] split = str.split(",");

            String s = "";

            if (split.length == 2){
                if (split[0].endsWith("/") && split[1].startsWith("/")){
                    s = split[0].substring(0, split[0].lastIndexOf("/")) + split[1];
                }else if (!split[0].endsWith("/") && split[1].startsWith("/")){
                    s = split[0] + split[1];
                }else if (!split[0].endsWith("/") && !split[1].startsWith("/")){
                    s = split[0] + "/" + split[1];
                }else if (split[0].endsWith("/") && !split[1].startsWith("/")){
                    s = split[0] + split[1];
                }
            }

            if (!s.startsWith("/")){
                s = "/" + s;
            }else if (s.endsWith("/")){
                s = s.substring(0,s.lastIndexOf("/"));
            }

            System.out.println(s);

        }
    }


}
