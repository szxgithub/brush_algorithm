package com.leetcode.hot100.middle;

import java.util.ArrayList;
import java.util.List;

public class ItemTwentyTwo {

    /**
     * 括号生成
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n){

        ArrayList<String> combinations = new ArrayList<>();

        generateAll(new char[2*n],0,combinations);

        return combinations;

    }

    private void generateAll(char[] chars, int i, ArrayList<String> combinations) {

        if(i == chars.length){
            if(valid(chars)){
                combinations.add(new String(chars));
            }
        }else {
            chars[i] = '(';
            generateAll(chars,i+1,combinations);
            chars[i] = ')';
            generateAll(chars,i+1,combinations);
        }

    }

    //
    private boolean valid(char[] chars) {

        int  balance = 0;

        for (char c:chars){
            if(c == '('){
                balance++;
            }else {
                balance--;
            }
            if (balance < 0){
                return false;
            }
        }
        return balance == 0;
    }

}
