package od2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main37 {

    /*
    优雅数组

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 数组的长度
        int n = sc.nextInt();
        // 优雅阈值
        int k = sc.nextInt();

        int[] nums = new int[n];
        for (int i =0; i<nums.length; i++){
            nums[i] = sc.nextInt();
        }

        // 将数组中的数字作为index 新建一个长度的数组  数组中的数字则是index出现的次数
        int[] lenInts = new int[n+1];
        int res = 0;
        int right = 0;
        for (int i =0; i <n; i++){
            if (i > 0){
                lenInts[nums[i-1]]--;
            }else {
                lenInts[nums[i]]++;
            }
            // 最大值为数组中元素出现的次数最多
            int max = Arrays.stream(lenInts).max().getAsInt();
            if (max == k){
                res += n -right;
                continue;
            }
            for (int j = right + 1; j<n; j++){
                lenInts[nums[j]]++;
                max = Arrays.stream(lenInts).max().getAsInt();
                if (max == k){
                    res += n -j;
                    right = j;
                    break;
                }
            }
        }

        System.out.println(res);

    }

}
