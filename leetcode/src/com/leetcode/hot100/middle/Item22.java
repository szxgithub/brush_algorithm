package com.leetcode.hot100.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item22 {

    /**
     * 数字 n 代表生成括号的对数，  请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * @param n
     * @return
     */

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n,n,"");
        return res;
    }

    /**
     *
     * @param left  左括号的数量
     * @param right 右括号的数量
     * @param curStr
     */
    private void dfs(int left, int right, String curStr){
        if (left == 0 && right == 0){ // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }

        if (left > 0){
            dfs(left - 1, right, curStr + "(");
        }

        if (right > left){
            dfs(left,right-1,curStr + ")");
        }

    }

    public static void main(String[] args) {
        Item22 item22 = new Item22();
        List<String> strings = item22.generateParenthesis2(3);
        System.out.println(Arrays.toString(strings.toArray()));
    }

    /**
     * 暴力破解
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

}
