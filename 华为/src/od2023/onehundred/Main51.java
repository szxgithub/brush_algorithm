package od2023.onehundred;

import java.util.*;
import java.util.stream.Collectors;

public class Main51 {

    /*

    猜字谜
    小王设计了一个简单的猜字谜游戏，游戏的谜面是一个错误的单词，比如 nesw
    满足下面任一条件表示猜中：
        1、变换顺序以后是一样的
        2、字母去重以后是一样的

    请你帮忙写一个程序在谜底库中找到正确的谜底，谜面是多个单词，找不到的话，返回not found

    输入描述：
        谜面单词列表，以”,"分隔
        谜底单词列表，以”,"
    输出描述：
        匹配到的正确单词列表，以“，”分隔
        如果找不到，返回"not found"


输入：
bdni,wooood
bind,wrong,wood
输出：
bind,wood

     */


    /*
        通过率100%  去重加字典排序
     */
    public String getResult(String[] issues, String[] answers){

        ArrayList<String> ans = new ArrayList<>();
        // 遍历谜面
        for (String issue : issues){
            String str1 = getSortedAndDistinctStr(issue);
            boolean find = false;

            // 遍历谜底
            for (String answer : answers){
                String str2 = getSortedAndDistinctStr(answer);
                if (str1.equals(str2)){
                    ans.add(answer);
                    find = true;
                }
            }

            if (!find){
                ans.add("not found");
            }
        }

        StringJoiner sj = new StringJoiner(",",",","");
        for (String an : ans){
            sj.add(an);
        }

        return sj.toString();
    }

    public static String getSortedAndDistinctStr(String str){
        //  Hashset不会记录元素加入顺序，会按照Hash算法排序，因此不需要额外排序
        HashSet<Character> set = new HashSet<>();
        for (char c : str.toCharArray()){
            set.add(c);
        }
        return set.toString();
    }

}
