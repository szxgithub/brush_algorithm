package od2022I;

import java.util.Scanner;

public class Main55 {

    /*

    两数之和绝对值最小


    输入： -3 -1 5 7 11 15
    输出： 2

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] split = str.split(" ");

        int[] nums = new int[split.length];

        for (int i =0; i<nums.length; i++){
            nums[i] = Integer.parseInt(split[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int i =0; i<nums.length - 1; i++){
            for (int j = i+1; j<nums.length; j++){
                int a = nums[i];
                int b = nums[j];
                int count = Math.abs(a+b);
                ans = Math.min(count,ans);
            }
        }

        System.out.println(ans);

    }

}
