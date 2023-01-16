package com.leetcode.hot100.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Item49 {

    /**
     *
     * 字母异位词分组
     *
     * 给你一个字符串数组，请你将字母异位词组合在一起
     *
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次
     *
     * @param strs
     * @return
     */
    public static List<List<String>>  groupAnarams(String[] strs){

        List<List<String>> res = new ArrayList<>();

        boolean[] used = new boolean[strs.length];

        for (int i = 0; i<strs.length; i++){
            String str = strs[i];
            List<String> list = new ArrayList<>();
            if (!used[i]){
                list.add(str);
                res.add(list);
                used[i] = true;
            }else {
                continue;
            }
            for (int j = i+1; j < strs.length;j++){

                if (strs[j] == "" && str.equals(strs[j])){
                    list.add(strs[j]);
                    used[j] = true;
                    break;
                }

                int count = 0;
                for (int k = 0; k < strs[j].length(); k++){
                    char c = strs[j].charAt(k);
                    if (strs[j].length() == str.length() && str.contains(c + "")){
                        count++;
                    }else {
                        break;
                    }
                    if (count == str.length()){
                        list.add(strs[j]);
                        used[j] = true;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        String[] strs = {"",""};
        List<List<String>> lists = groupAnarams(strs);
        System.out.println(lists);

    }

    /**
     * 排序
     * 由于互为字母异位词的两个字符串包含相同的字母，因此对两个字符串分别进行排序之后得到的字符串一定是相同的，
     * 故可以将排序之后的字符串作为哈希表的键
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs){

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * 计数法
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs){
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i<length; i++) {
                counts[str.charAt(i) - 'a']++;
            }

            // 将每个出现次数大于0的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++){
                if (counts[i] != 0){
                    sb.append((char)('a' + i));
                    sb.append(counts[i]);
                }
            }

            String key = sb.toString();

            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }

        return new ArrayList<>(map.values());

    }

}
