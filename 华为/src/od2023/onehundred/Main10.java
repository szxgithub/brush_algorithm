package od2023.onehundred;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main10 {

    /*

    真正的密码

    在一行中输入一个字符串数组，其中一个字符串的所有以索引0开头的子串在数组中都有，则该字符串就是潜在密码

    在所有潜在密码中最长的是真正的密码，如果多个长度相同的真正密码，取字典序最大的返回

    输入描述：
        密码本是由一个字符串数组组成，不同元素使用空格隔开
    输出描述：
        一个字符串

输入：
b eredderd bw bww bwwl bwwlm bwwln
输出：
bwwln


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
                // 判断每一个新密码是否在密码本中存在
                if (!hashSet.contains(str.substring(0,j))){
                    continue outer;
                }
            }
            System.out.println(str);
            return;
        }

        // 如果没有输出空字符串
        System.out.println("");

    }

}
