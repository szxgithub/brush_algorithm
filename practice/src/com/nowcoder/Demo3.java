package com.nowcoder;

import java.util.Scanner;

public class Demo3 {
    /**
     * 明明的随机数
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] target = new int[1000];

        while (scan.hasNextInt()) {
            for (int i = 0; i < 1000; i++) {
                target[i] = 0;
            }

            int num = scan.nextInt();
            for (int i = 0; i < num; i++) {
                int next = scan.nextInt();
                target[next] = next;

            }
            for (int i = 0; i < 1000; i++) {
                if (target[i] == 0) {

                } else {
                    System.out.println(target[i]);
                }
            }
        }
    }

}
