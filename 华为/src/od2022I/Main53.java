package od2022I;

import java.util.Scanner;

public class Main53 {

    /*

    5键键盘的输出


     */


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");

        String temp = "";//剪贴板
        String screen = "";//屏幕
        String select = "";//选择的

        for(int i=0;i<s.length;i++){

            switch (s[i]){
                case "1":
                    if(select!=""){
                        screen = "a";
                        select = "";
                    }else {
                        screen+="a";
                    }
                    break;
                case "2":
                    if(select!=""){
                        temp = select;
                    }
                    break;
                case "3":
                    if(select!=""){
                        temp = select;
                        screen = "";
                        select = "";
                    }
                    break;
                case "4":
                    if(select!=""){
                        screen = temp;
                        select = "";
                    }else {
                        screen+=temp;
                    }
                    break;
                case "5":
                    if(screen!=""){
                        select = screen;
                    }
                    break;
            }
        }
        System.out.println(screen.length());
    }

}
