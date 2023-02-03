package od2023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main19 {
    /*

    寻找相似单词

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        String[] words = new String[N];

        for (int i = 0; i<N; i++){
            words[i] = sc.nextLine();
        }

        String input = sc.nextLine();

        List<String> list = new ArrayList<>();
        for (int i=0; i<words.length; i++){
            if (words[i].length() ==  input.length()){
                int count = 0;
                for (int j =0; j<input.length(); j++){
                    if (words[i].contains(input.charAt(j) + "")){
                        count++;
                    }
                }
                if (count == words[i].length()){
                    list.add(words[i]);
                }
            }
        }

        Collections.sort(list);

        String res = "";
        for (String str : list){
            res += str;
            res += " ";
        }

        if (res.isEmpty()){
            System.out.println("null");
        }else {
            System.out.println(res.substring(0,res.length()-1));
        }

    }

}
