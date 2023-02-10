package od2023;

import java.util.Arrays;
import java.util.Scanner;

public class Main87 {

    /*
    木板

    加长木板后，最短的木板长度最大可以为多少

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 木板数
        int n = sc.nextInt();
        // 木料长度
        int m = sc.nextInt();

        int[] wood = new int[n];
        for (int i = 0; i<wood.length; i++){
            wood[i] = sc.nextInt();
        }


        Arrays.sort(wood);

        while (m>0){
            m--;    //木材一段一段的截
            for(int i=1; i<n; i++){
                if(wood[i] > wood[i-1]){
                    wood[i-1] ++;   //碰到比后面的短的就加一截
                    break;
                }
                if(i == n-1){
                    wood[i] ++; //所有木材一样长则在最后一根加一截
                }
            }
        }

        System.out.println(wood[0]);



    }




}
