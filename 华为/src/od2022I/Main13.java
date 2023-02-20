package od2022I;

import java.util.Arrays;
import java.util.Scanner;

public class Main13 {

    /**
     *
     * 有A，B两个同学想要分苹果。A的想法是使用二进制进行，1 + 1相加不进一位，如（9 + 5 = 1001 +101 = 12）。
     * B同学的想法是使用十进制进行，并且进一位。会输入两组数据，一组是苹果总数，一组分别是每个苹果的重量。如果让B同学在满足A同学的情况下获取到苹果的总重量且返回，如果不能则返回-1。
     * 输入
     * 3
     * 3 5 6
     *
     * 返回
     * 11
     *
     *
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){

            int num = sc.nextInt();

            int[] apple = new int[num];

            for (int i = 0; i<num; i++){
                apple[i] = sc.nextInt();
            }

            int asInt = Arrays.stream(apple).min().getAsInt();

            int sum = Arrays.stream(apple).sum();
            int max = sum - asInt;

            System.out.println(max);


        }

    }

}
