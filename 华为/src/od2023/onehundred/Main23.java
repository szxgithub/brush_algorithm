package od2023.onehundred;

import java.util.Arrays;
import java.util.Scanner;

public class Main23 {

    /*

    学校的位置（学校选址）

    学校和所有学生都在一条直线之上，请问学校在什么位置，使得学校到各个学生家庭的距离和最短

    如果有多个位置，则输出最小的

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 表示有N户家庭
        int N = Integer.valueOf(sc.nextLine());

        String str = sc.nextLine();
        String[] s = str.split(" ");
        // 每户家庭的位置
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

    /*
     中位数定理 ： 中位数的性质，给定一个数列，所有数与中位数的差的绝对值之和最小
     将学校建立在所有学生家庭位置的共同中心点位置的距离最短
     */
    public int getResult(int[] arr){

        Arrays.sort(arr);

        int len = arr.length;

        if (len%2 == 0){
            int mid = len/2;
            return arr[mid-1];
        }else {
            return arr[len/2];
        }

    }

}
