package od2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main55 {

    /*

    最差产品奖

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int M = Integer.parseInt(sc.nextLine());

        String str = sc.nextLine();
        String[] split = str.split(",");
        int[] ints = Arrays.stream(split).mapToInt(value -> Integer.parseInt(value)).toArray();

        List<Integer> res = new ArrayList<>();
        for (int i =0; i<ints.length; i++){
            int[] tmp;
            if (i+M < ints.length){
                tmp = Arrays.copyOfRange(ints, i, i + M);
                int asInt = Arrays.stream(tmp).min().getAsInt();
                res.add(asInt);
            }else {
                tmp = Arrays.copyOfRange(ints, i, ints.length);
                int asInt = Arrays.stream(tmp).min().getAsInt();
                res.add(asInt);
                break;
            }
        }

        System.out.println(res);

    }

    /*
    双层for循环求出一定区间的最小值
     */
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.nextLine();

        String[] strs = sc.nextLine().split(",");
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < strs.length - M + 1; i++){
            int min = Integer.MAX_VALUE;
            for (int j = i; j <i+M; j++){
                min = Math.min(min,Integer.valueOf(strs[j]));
            }
            res.add(min);
        }

        System.out.println(res);
    }

}
