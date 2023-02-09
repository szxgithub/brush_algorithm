package od2023;

import java.util.Arrays;
import java.util.Scanner;

public class Main77 {

    /*
    简单的自动曝光

    //todo
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] s = str.split(" ");
        int[] ints = Arrays.stream(s).mapToInt(value -> Integer.valueOf(value)).toArray();

        int sum = Arrays.stream(ints).sum();

        // 平均差
        double average = (double) sum/ints.length - 128;
        int res = (int) Math.round(average);

        // newImg小于0的个数
        int lessThenZeroNum = 0;
        int lessThenZero = 0;
        for (int i = 0; i <ints.length; i++){
            if (ints[i] - res < 0){
                lessThenZeroNum++;
                lessThenZero += ints[i] - res;
            }
        }

        res -= lessThenZero/(ints.length - lessThenZeroNum);
        System.out.println(0-res);
    }

    public static void main2(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] S = str.split(" ");
        int len = S.length;

        double sum = 0;
        for (int i = 0; i < S.length; i++) {
            sum += Integer.parseInt(S[i]);
        }


        double avgerages = sum/len - 128;
        boolean isAdd = avgerages<0;
        int avg = Math.abs((int)Math.round(avgerages));
        int zero = 0;
        int zeroSum = 0;
        int daYu = 0;
        int daYuSum = 0;
        for (int i = 0; i < S.length; i++) {
            int i1 = Integer.parseInt(S[i]);
            if (isAdd) {
                if (i1+avg>255) {
                    daYu++;
                    daYuSum += i1+avg-255;
                }
            } else {
                if (i1-avg<0) {
                    zero++;
                    zeroSum += avg-i1;
                }
            }
        }
        avg += zeroSum / len-zero;
        avg += daYuSum / len-daYu;
        System.out.println(isAdd?avg:-avg);

    }

}
