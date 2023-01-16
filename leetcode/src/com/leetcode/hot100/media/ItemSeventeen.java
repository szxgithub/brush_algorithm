package com.leetcode.hot100.media;

import java.util.*;

/*

电话号码的字母组合  回溯法

 */
public class ItemSeventeen {

    public List<String> letterCombinations(String digits){

        List<String> combinations = new ArrayList<>();
        if(digits.length() == 0){
            return combinations;
        }

        Map<Character,String> phoneMap = new HashMap<Character,String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };

        backtrack(combinations,phoneMap,digits,0,new StringBuffer());

        return combinations;

    }

    // "23"
    public void backtrack(List<String> combinations, Map<Character,String> phoneMap,
                          String digits, int index, StringBuffer combination){

        if(index == digits.length()){
            combinations.add(combinations.toString());
        }else{
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int letterCount = letters.length();
            for(int i = 0; i<letterCount; i++){
                combination.append(letters.charAt(i));
                backtrack(combinations,phoneMap,digits,index+1,combination);
                combination.deleteCharAt(index);
            }
        }

    }



}
