package od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main39{

    /**
     *
     *
     * 求字符串中所有整数的最小和
     *
     *
     *
     * */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int len = s.length();
        List<Integer> list = new ArrayList<>();
        String temp = "";
        boolean isFuhao = false;

        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                if(isFuhao){
                    temp+=c;    //有负号的情况下数字越大越好，直接拼接
                }else {
                    list.add(Integer.valueOf(String.valueOf(c)));   //没有负号直接加入集合
                }
            }else if(c=='-'){
                if(temp!="" && temp!="-"){    //temp中有值且不是一个“-”单字符串的情况下
                    list.add(Integer.valueOf(temp));
                }
                isFuhao = true; //说明下一个字符串有了负号
                temp = "-";
            }else {
                /**
                 字母和“+”的情况下进入
                 * */
                if(temp!="" && temp!="-"){
                    list.add(Integer.valueOf(temp));
                }
                temp = "";  //无论之前是什么，都需要置空
                isFuhao = false;
            }
        }
        int res = 0;
        for (int i:list
        ) {
            res+=i;
        }
        System.out.println(res);
    }
}
