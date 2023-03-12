package od2023.onehundred;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main10 {

    /*

    真正的密码

    在一行中输入一个字符串数组，其中一个字符串的所有以索引0开头的子串在数组中都有，则该字符串就是潜在密码

    在所有潜在密码中最长的是真正的密码，如果多个长度相同的真正密码，取字典序最大的返回

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");

        HashSet<String> hashSet = new HashSet<>(Arrays.asList(arr));

        // 字符串先按长度升序，长度相同按照字典升序
        Arrays.sort(arr, (o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length());

        outer:
        for (int i = arr.length-1; i>= 0; i--){
            String str = arr[i];
            for (int j = str.length() - 1; j>= 1; j--){
                if (!hashSet.contains(str.substring(0,j))){
                    continue outer;
                }
            }
            System.out.println(str);
            return;
        }

        System.out.println("");

    }

}
