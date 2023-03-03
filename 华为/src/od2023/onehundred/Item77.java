package od2023.onehundred;

import java.util.*;

public class Item77 {

    /*

    回文字符串
    如果一个字符串正读和反读一样（大小写敏感），则称为一个回文串

    给你一个仅包含 大小写字母的字符串，请用这些字母构造出一个最长的回文串，若有多个最长的，返回其中字典序最小的回文串

    字符串中每个位置的字母最多备用一次，也可以不用

    输入：
    abczcccddzz
    输出：
    ccdzazdcc

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String res = getResult(str);

        System.out.println(res);

    }

    /*
    分为三部分，
    左边和右边部分互为倒序
    中间部分可以是空字符串，也可以是单字母
     */
    private static String getResult(String str) {
        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i<str.length(); i++){
            char c  = str.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        List<Character> list = new ArrayList<>();
        // 中间部分
        String mid = "";

        for (char c : map.keySet()){
            Integer integer = map.get(c);

            // 字母出现次数为偶数，可以平分到左右
            if (integer >= 2){
                for (int i = 0; i < integer/2; i++){
                    list.add(c);
                }
            }

            // 对于单字母和剩余无法成对的字母，记录字典序最小的到mid中
            if (integer%2 != 0 &&
                    ("".equals(mid)||mid.compareTo(c + "") > 0)){
                mid = c + "";
            }
        }

        list.sort(Comparator.comparingInt(a -> a));

        StringBuilder sb = new StringBuilder();
        for (Character c : list){
            sb.append(c);
        }

        return sb + mid + sb.reverse();
    }

}
