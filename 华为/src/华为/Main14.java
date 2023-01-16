package 华为;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = reverse(str);
        System.out.println(str);
    }

    public static String reverse(String sentence){
        String[] strs = sentence.split(" ");
        List<String> list = Arrays.asList(strs);
        Collections.reverse(list);
        String result = "";
        for(int i  = 0;i<list.size();i++){
            result+= list.get(i) + " ";
        }
        result = result.trim();
        return result;
    }

    public String reverse1(String sentence){
        String[] arr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i= arr.length-1;i>=0;i--){
            sb.append(arr[i] + " ");

        }
        return sb.toString().trim();
    }
}
