package od2023.twohundred;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main18 {

    /*

    基站维修工程师
    某地方有n个基站，已知各基站之间的距离为s, 并且基站X到基站Y的距离，与基站Y到基站X的距离并不一定会相同

    从基站1出发，途径每个基站1次，然后返回基站1，需要你选择一条距离最短的路径

    输入描述：
        站点数n 和 各站点之间的距离
    输出描述：
        最短路程的数值

     */

    /*
    这是我自己逻辑分析解法
     */
    public static void main2(String[] args) {

        Scanner sc = new Scanner(System.in);

        // n个基站
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

    利用回溯的方法
    将所有可能的路线模拟一遍

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
            List<Integer> path = new ArrayList<>();
            // 从基站2开始走
            path.add(i);
            handle(nums,i,path,nums[0][i]);
        }

        System.out.println(min);
    }

    /**
     *
     * @param nums
     * @param index 到达的基站
     * @param path 路过的基站
     * @param sum 走过的路程
     */
    private static void handle(int[][] nums, int index, List<Integer> path, int sum) {

        if (path.size() + 1 == nums.length){
            min = Math.min(min,sum + nums[index][0]);
        }else {
            for (int i = 1; i <nums.length; i++){
                // 已经走过的基站不需要再走
                if (path.contains(i)){
                    continue;
                }
                // 添加走过的基站
                path.add(i);
                handle(nums,i,path,sum + nums[index][i]);
                path.remove(path.size()-1);
            }
        }

    }

}
