package od2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main52 {

    /*

    统计差异值大于相似值二元组个数

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i< nums.length; i++){
            nums[i] = sc.nextInt();
        }

        List<int[]> list = new ArrayList<>();
        for (int i =0 ;i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                // 异或运算
                int chayi = nums[i]^nums[j];
                // 与运算
                int xiangsi = nums[i]&nums[j];
                if (chayi > xiangsi){
                    list.add(new int[]{chayi,xiangsi});
                }
            }
        }

        System.out.println(list.size());

    }

}
