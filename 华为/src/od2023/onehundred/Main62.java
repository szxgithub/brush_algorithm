package od2023.onehundred;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main62 {
    /*

    寻找相似单词
    相似单词：给定一个单词X，如果通过任意交换单词中字母的位置得到不同的单词Y,那么定义Y是X的相似单词

    字典序排序：大写字母 < 小写字母

    输入描述：
        单词个数N
        每一行一个单词
        最后一行为待检测单词
    输出描述:
        找出相似的单词，按照字典序大小排列输出，中间以空格分开，如果不存在输出null

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        String[] words = new String[N];

        for (int i = 0; i<N; i++){
            words[i] = sc.nextLine();
        }

        // 待检测的单词
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
