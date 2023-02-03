package od2023;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.ToIntFunction;

public class Main31 {


    /*
    区块链文件转储系统

    采用 滑动窗口解法

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // SATA硬盘容量
        int M = sc.nextInt();
        sc.nextLine();

        String[] s = sc.nextLine().split(" ");
        int[] ints = Arrays.stream(s).mapToInt(value -> Integer.valueOf(value)).toArray();

        // 求最大子序列和 且和不超过容量M
        int left = 0;
        int right = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        while (max != M && (right < ints.length || sum > max)){
            if (sum <= M){
                max = Math.max(max,sum);
                if (right < ints.length){
                    sum += ints[right];
                    right++;
                }
            }else {
                sum -= ints[left];
                left++;
            }
        }

        System.out.println(max);

    }

}
