package od2023.onehundred;

import java.util.*;

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

输入：
4
abc
dasd
tad
bca
abc
输出：
abc bca

     */

    /*
    简单排序题
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 单词个数
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
                String s1 = sortStr(words[i]);
                String s2 = sortStr(input);
                if (s1.equals(s2)){
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

    /*
    转换成排序字符串
     */
    private static String sortStr(String words) {
        char[] chars = words.toCharArray();
        Arrays.sort(chars);
        String s = String.valueOf(chars);
        return s ;
    }

}
