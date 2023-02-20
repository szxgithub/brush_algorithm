package od2022I;

import java.util.Scanner;

public class Main17 {

    /**
     *
     * 数组连续和
     *
     * 给定一个含有N个正整数的数组，求出有多少个连续区间（包括单个正整数），它们的和大于等于X
     *
     *
     * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){

            int N = sc.nextInt();
            int x = sc.nextInt();

            int[] nums = new int[N];
            for (int i = 0; i<nums.length; i++){
                nums[i] = sc.nextInt();
            }

            // 有多少个连续子数组它们的和大于等于X
            int res = 0;
            for (int i = 0; i<nums.length; i++){
                int sum = 0;
                sum += nums[i];
                if (sum >= x){
                    res += nums.length - i;
                    continue;
                }
                for (int j = i + 1; j <nums.length; j++){
                    sum += nums[j];
                    if (sum >= x){
                        res += nums.length - j;
                        break;
                    }
                }
            }

            System.out.println(res);

        }

    }

}
