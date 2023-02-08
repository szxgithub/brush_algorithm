package od2023;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main62 {

    /*

    分奖金
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i =0; i<nums.length; i++){
            nums[i] = sc.nextInt();
        }

        for (int i =0 ;i<nums.length; i++){
            for (int j =i+1; j < nums.length; j++){
                if (nums[j] > nums[i]){
                    nums[i] = (nums[j] - nums[i])*(i+1);
                }
            }
        }

        String collect = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(collect);

    }

}
