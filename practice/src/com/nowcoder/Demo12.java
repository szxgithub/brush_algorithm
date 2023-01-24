package com.nowcoder;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 汽水瓶
 */
public class Demo12 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int temp = sc.nextInt();
            if(temp!=0){
                list.add(temp);
            }else{
                break;
            }
        }

        for(int i=0;i<list.size();i++){
            int tmp = list.get(i);
            int res = tmp/2;
            System.out.println(res);
        }
    }
}
