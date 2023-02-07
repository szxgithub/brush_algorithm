package od2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main60 {

    /*

    基站维修工程师
     */

    public static void main2(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] nums = new int[n][n];
        for (int i =0;i <n; i++){
            for (int j = 0; j<n; j++){
                nums[i][j] = sc.nextInt();
            }
        }

        int sum = 0;
        for (int i = 0; i <n; i++){
            int min = Integer.MAX_VALUE;
            int nextIndex = 0;
            for (int j = 0; j<n; j++){
                if (nums[i][j] != 0 && min > nums[i][j]){
                    min = nums[i][j];
                    nextIndex = j;
                }
            }
            sum += min;
            if (nextIndex == 0){
                break;
            }
            i = nextIndex;
            i--;
        }

        System.out.println(sum);

    }

    /*

    利用回溯的方法将所有可能的路线模拟一遍

     */
    public static Integer min = Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] nums = new int[n][n];
        for (int i =0;i <n; i++){
            for (int j = 0; j<n; j++){
                nums[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <nums.length; i++){
            List<Integer> stepList = new ArrayList<>();
            stepList.add(i);
            handle(nums,i,stepList,nums[0][i]);
        }

        System.out.println(min);
    }

    /**
     *
     * @param nums
     * @param index 到达的基站
     * @param stepList 路过的基站
     * @param sum 走过的路程
     */
    private static void handle(int[][] nums, int index, List<Integer> stepList, int sum) {

        if (stepList.size() + 1 == nums.length){
            min = Math.min(min,sum + nums[index][0]);
        }else {
            for (int i = 1; i <nums.length; i++){
                if (stepList.contains(i)){
                    continue;
                }
                stepList.add(i);
                handle(nums,i,stepList,sum + nums[index][i]);
                stepList.remove(stepList.size()-1);
            }
        }

    }
}
