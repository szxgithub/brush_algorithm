package od2023.onehundred;

import java.util.Arrays;
import java.util.Scanner;

public class Main32 {

    /*
    木板（最短木板长度）
    小明有n块木板，第i块木板长度为ai
    小明买了一块长度为m的木料，这块木料可以任意切割，为了让最短的木板尽量长，请问，加长后的最短木板长度是多少

    加长木板后，最短的木板长度最大可以为多少

    输入：
    5 3
    4 5 3 5 5
    输出：
    5

     */

    /*
    贪心思维
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
