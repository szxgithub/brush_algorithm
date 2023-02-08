package od2023;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main69 {

    /*
    寻找链表的中间结点

    输入：
    00100 4
    00000 4 -1
    00100 1 12309
    33218 3 00000
    12309 2 33218
    输出
    3

     */

    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);

        int headAddress = sc.nextInt();
        int n = sc.nextInt();
        HashMap<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i<n; i++){
            int address = sc.nextInt();
            int value = sc.nextInt();
            int next = sc.nextInt();
            map.put(address,new int[]{value,next});
        }

        int count = 0;
        int res = 0;
        while (count < n/2 + 1){
            int[] ints = map.get(headAddress);
            headAddress = ints[1];
            res = ints[0];
            count++;
        }

        System.out.println(res);

    }

}
