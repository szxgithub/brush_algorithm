package com.nowcoder;

import java.util.*;

/**
 *
 * 单词接龙
 * 答案链接:https://blog.csdn.net/u013598405/article/details/114239804
 *
 */
public class Demo2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i<n ;i++){
            list.add(scanner.nextLine());
        }

        StringBuilder stringBuilder = new StringBuilder();
        String head = list.get(k);
        stringBuilder.append(head);
        list.remove(k);
        String tail = head.substring(head.length()-1);
        while (true){
            TreeSet<String> strSet = new TreeSet<>();
            for (int i = 0;i<list.size();i++){
                String word = list.get(i);
                if (word.startsWith(tail)){
                    strSet.add(word);
                }
            }
            if (strSet.size() == 0){
                break;
            }
            String first = strSet.pollFirst();
            int length = first.length();
            //遍历找寻首字母相同的单词中长度最长的一个
            for (String s : strSet){
                if (s.length() > length){
                    length = s.length();
                    first = s;
                }
            }
            //新的字符串的尾字母
            tail = first.substring(first.length() - 1);
            stringBuilder.append(first);
            list.remove(first);
        }
        System.out.println(stringBuilder.toString());

    }

  /*  public String dancijielong(String[] strs, int begin){




    }*/

}
