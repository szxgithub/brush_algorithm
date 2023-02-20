package od2022I;

import java.util.Arrays;
import java.util.Scanner;

public class Main42{

    /**
     *
     * 乱序整数序列两数之和绝对值最小
     *
     * 输入：
     * -1 -3 7 5 11 15
     * 输出：
     * -3 5 2
     *
     *
     * */

    public static void main2(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");
        int n = strings.length;
        int min = Integer.MAX_VALUE;
        int num1 = 0;
        int num2 = 0;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int a = Integer.valueOf(strings[i]);
                int b = Integer.valueOf(strings[j]);
                int count = Math.abs(a+b);    //进行绝对值计算
                min = Math.min(count, min);
                if(min==count){
                    num1 = a;
                    num2 = b;
                }
            }
        }

        System.out.println(num1+" "+num2+" "+min);
    }

    public static void main(String[] args) {

        // 一次循环取最小的负数和最小的正数
        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");

        int[] nums = new int[strings.length];

        for (int i = 0; i <nums.length; i++){
            nums[i] = Integer.parseInt(strings[i]);
        }

        Arrays.sort(nums);

        int minNegative = Integer.MAX_VALUE;
        int minPositive = Integer.MAX_VALUE;
        for (int i = 0; i< nums.length-1; i++){
            if (nums[i] < 0){
                minNegative = nums[i];
                break;
            }else {
                minNegative = nums[i];
                minPositive = nums[i+1];
                break;
            }
        }

        if (minNegative != Integer.MAX_VALUE || minPositive != Integer.MAX_VALUE){
            for (int i = 0; i< nums.length-1; i++){
                if (nums[i] < 0 && nums[i+1] >= 0){
                    minPositive = nums[i+1];
                    break;
                }
            }
        }

        int abs = Math.abs(minNegative + minPositive);
        System.out.println(minNegative + " " + minPositive + " " + abs);


    }
}
