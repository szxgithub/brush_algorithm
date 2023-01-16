package com.leetcode.hot100.hard;

import java.util.*;

public class Item76 {

    /**
     *
     * 最小覆盖字串
     *
     * 给你一个字符串s,一个字符串t,
     * 返回s中涵盖t所有字符的最小字串，如果s中不存在涵盖t所有字符串的字串，则返回空字符串""
     *
     * @param s
     * @param t
     * @return
     */

    Map<Character,Integer> ori = new HashMap<Character,Integer>();

    Map<Character,Integer> cnt = new HashMap<>();

    public String minWindow(String s, String t){

        int tlen = t.length();
        for (int i = 0; i < tlen; i++){
            char c = t.charAt(i);
            ori.put(c,ori.getOrDefault(c,0) + 1);
        }

        int l = 0, r = -1;

        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;

        int sLen = s.length();

        while (r < sLen){
            ++r;
            if (r<sLen && ori.containsKey(s.charAt(r))){
                cnt.put(s.charAt(r),cnt.getOrDefault(s.charAt(r),0) + 1);
            }
            while (check() && l <= r){
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }

        return ansL == -1 ? "" : s.substring(ansL, ansR);

    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public String minWindow2(String s, String t){

        char[] chars = s.toCharArray(), chart = t.toCharArray();
        int n = chars.length, m = chart.length;

        int[] hash = new int[128];

        for (char ch : chart){
            hash[ch]--;
        }

        String res = "";
        for (int i = 0, j = 0, cnt = 0; i < n; i++){
            hash[chars[i]]++;
            if (hash[chars[i]] <= 0){
                cnt++;
            }
            while (cnt == m && hash[chars[j]]>0){
                hash[chars[j++]]--;
            }
            if (cnt == m){
                if (res.equals("") || res.length() > i-j+1){
                    res = s.substring(j,i+1);
                }
            }
        }

        return res;




    }


    /**
     * 暴力求解
     *
     * 枚举输入字符串S的所有长度大于等于T的字串
     *
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow3(String s, String t){

        char[] array = t.toCharArray();
        int tlen = t.length();

        Map<Character,Integer> tMap = new HashMap<>();
        for (int k = 0; k<array.length;k++){
            tMap.put(array[k],tMap.getOrDefault(array[k],0) + 1);
        }

        String res = "";
        for (int i = 0; i<s.length();i++){
            for (int j = i+1; j <= s.length();j++){
                if ((j-i) < tlen){
                    continue;
                }else {
                    String extracted = extracted(s, array, tMap, i, j);
                    if (res == "" && extracted != ""){
                        res = extracted;
                    }else if (res != "" && extracted != ""){
                        res = extracted.length() < res.length() ? extracted : res;
                    }
                }
            }
        }

        return res;
    }

    private String extracted(String s, char[] array, Map<Character, Integer> tMap, int i, int j) {
        String substring = s.substring(i, j);
        Map<Character,Integer> map = new HashMap<>();
        for (int l = 0; l <substring.length(); l++){
            map.put(substring.charAt(l),map.getOrDefault(substring.charAt(l),0) + 1);
        }
        for (int k = 0; k < array.length; k++){
            Integer ori = tMap.get(array[k]);
            Integer tmp = map.get(array[k]);
            if (tmp == null){
                return "";
            }
            if (ori > tmp){
                return "";
            }
        }
        return substring;
    }


    public static void main(String[] args) {

        String s = "xeaifhaqslynbcwxncwgeezbrjorzyuwevejcecuscjvgfutkrcqxbromihlgcjnzpybwcxqeglknhgzyiqxljnyrvlazvnyklbgoywugjftrltrvlrgueeobsoandazqbigbgbhqgdjtycojtwfydtbvjekmejdirjlymvquybnyddjxaoxfkyatckijvlrnwcnjxfdxgtvjweiyvfdhefaipkrnviaunpfmukkcdhlcmwcjbgqhnsqfdhsasuwhjbtfmdhrluvzqykugcbtutyzdqcxkyevaxcodjhogdpwbzsjducxpdzsvbpizvfbtirwtzmzebyhcqqfmueczdwveofgjkhesbamaolgrlpvcfcqbhubmtythdzspizijbwlqjrjvgfznhprqmudfsyoxzimhhutjsebcykxgpywznnpbhuizuwythkbohwzzacbanyhewdfmsvpzryamuyhdkkurgvrjysjntqrrvxfnuvonvqbrqjvbvpucklligu";
        String t = "xbnpukocakzqzuhdlxoga";

        Item76 item76 = new Item76();
        String s1 = item76.minWindow3(s, t);
        System.out.println(s1);


    }

}
