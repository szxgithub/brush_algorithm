package com.leetcode.hot100.hard;

import java.util.Deque;
import java.util.LinkedList;

public class Item32 {

    /**
     * 最长有效括号
     *
     * 给你一个只包含'('和')'的字符串，找出最长有效（格式正确且连续）括号字串的长度
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s){

        int maxans = 0;

        Deque<Integer> stack = new LinkedList<>();

        stack.push(-1);

        for (int i = 0;i<s.length();i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxans = Math.max(maxans,i-stack.peek());
                }
            }
        }
        return maxans;

    }

    public int longestValidParentheses2(String s){

        int left = 0, right = 0, maxlength = 0;

        for (int i = 0;i<s.length();i++){
            if (s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }
            if (left == right){
                maxlength = Math.max(maxlength, 2*right);
            }else if (right > left){
                left = right = 0;
            }
        }

        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            if (s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }
            if (left == right){
                maxlength = Math.max(maxlength,2*left);
            }else if (left > right){
                left = right = 0;
            }
        }

        return maxlength;
    }

}
