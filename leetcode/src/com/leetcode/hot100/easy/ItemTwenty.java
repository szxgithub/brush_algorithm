package com.leetcode.hot100.easy;

import java.util.*;

public class ItemTwenty {

    /*
        有效的括号
     */

    public static boolean isValid(String s){

        int n = s.length();

        //有效字符串长度一定为偶数
        if(n%2 == 1){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if (stack.isEmpty()){
                    return false;
                }else{
                    Character pop = stack.pop();
                    if(c == ')' && pop == '('){
                        continue;
                    }
                    if(c == ']' && pop == '['){
                        continue;
                    }
                    if(c == '}' && pop == '{'){
                        continue;
                    }
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = isValid("()");
        System.out.println(
                valid
        );
    }

    public boolean isValid2(String s){
        int n = s.length();
        if(n%2==1){
            return false;
        }

        HashMap<Character,Character> pairs = new HashMap<Character, Character>(){{
            put(')','(');
            put('}','{');
            put(']','[');
        }};

        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(pairs.containsKey(c)){
                if(stack.isEmpty() || !stack.peek().equals(pairs.get(c))){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

}
