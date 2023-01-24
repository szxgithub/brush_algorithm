package com.nowcoder;

import java.util.Scanner;

/**
 *
 *
 *
 * 所有的质因数
 */
public class Demo4{


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()){
            long number = sc.nextLong();
            getResult(number);
        }
    }

    public static void getResult(long ulDataInput){
        long number = ulDataInput;
        while (number!=1){
            for(int i=2;i<=number;i++){
                if(number%i==0){
                    number/=i;
                    System.out.printf(i+" ");
                    break;
                }
            }
        }
    }

}
