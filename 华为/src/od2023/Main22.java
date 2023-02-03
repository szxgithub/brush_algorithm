package od2023;

import java.util.Scanner;

public class Main22 {

    /*
    光伏场地建设规划

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int width = sc.nextInt();
        int edge = sc.nextInt();
        int power = sc.nextInt();

        int[][] region = new int[length][width];

        for (int i =0 ; i<length; i++){
            for (int j = 0; j<width; j++){
                region[i][j] = sc.nextInt();
            }
        }

        int count = 0;
        for (int i =0;i<region.length - edge; i++){
            for (int j = 0; j<region[i].length - edge;j++){
                int sum = 0;
                for (int k = i; k <i+edge; k++){
                    for (int l = j; l <j+edge;l++){
                        sum += region[k][l];
                    }
                }
                if (sum >= power){
                    count++;
                }
            }
        }

        System.out.println(count);



    }

}
