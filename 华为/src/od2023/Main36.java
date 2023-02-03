package od2023;

import java.util.Arrays;
import java.util.Scanner;

public class Main36 {

    /*

    学校的位置
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = Integer.valueOf(sc.nextLine());

        String str = sc.nextLine();
        String[] s = str.split(" ");
        int[] location = Arrays.stream(s).mapToInt(value -> Integer.valueOf(value)).toArray();

        //输出一行 一个整数的表示确定的学校的位置 如果有多个位置相同，则输出值最小的位置

        int minIndex = 0;
        int distance = Integer.MAX_VALUE;
        for (int i =0;i<location.length; i++){
            int school = location[i];
            int sum = 0;
            for (int j = 0; j<location.length; j++){
                sum += Math.abs(school - location[j]);
            }
            if (sum <= distance){
                if (distance == sum){
                    minIndex = Math.min(minIndex,i);
                }else {
                    distance = sum;
                    minIndex = i;
                }
            }
        }

        System.out.println(location[minIndex]);

    }

}
