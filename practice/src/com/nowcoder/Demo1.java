package com.nowcoder;

import java.util.Scanner;
import java.util.Stack;

/**
 * 字符串消消乐
 *
 */
public class Demo1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int kuailexiaoxiaole = kuailexiaoxiaole(str);
        System.out.println(kuailexiaoxiaole);
    }

    public static int kuailexiaoxiaole(String str){

        StringBuilder res = new StringBuilder();

        Stack<Character> st= new Stack<>();
        Stack<Character> existSameCharacter = new Stack<>();

        for(int i = 0;i<str.length();i++){

            char c = str.charAt(i);
            if ( !((c >'A' && c <'Z') ||(c>'a' && c < 'z'))){
                return 0;
            }

            if (st.isEmpty()){
                if (!existSameCharacter.isEmpty()){
                    if (existSameCharacter.peek() != c){
                        st.push(c);
                    }
                }else{
                    st.push(c);
                }
            }else {
                Character peek = st.peek();
                if (peek == c){
                    st.pop();
                    existSameCharacter.push(c);
                }else {
                    st.push(c);
                }
            }

        }

        while (!st.isEmpty()){
            res.append(st.pop());
        }

        return res.reverse().length();

    }




}
