package od2023.onehundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main66 {

    /*

    天然蓄水库

    如何选取水库边界，使蓄水量最大
    山脉用正整数数组s表示，每个元素代表山脉的高度
    如果出现多个满足条件的边界，应选取距离最近的一组边界

    输出边界下标，和最大蓄水量，如果无法蓄水，则返回0，此时不返回边界

    输入：
    1 9 6 2 5 4 9 3 7
    输出：
    1 6:19

     */

    /*
    逻辑分析 双指针

     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        // 山脉的高度
        String[] s = str.split(" ");

        int[] nums = new int[s.length];
        for (int i =0 ; i<nums.length; i++){
            nums[i] = Integer.parseInt(s[i]);
        }

        // 蓄水量的高度为两边界的最小值， 如果有多个满足条件的边界，选取距离最近的一组边界

        int res =0;
        int indexLeft = 0;
        int indexRight = 0;
        for (int i = indexRight; i < nums.length-2; i++){

            int left = nums[i];
            int right = nums[i+1];

            // 左边界小于右边界， 不能形成蓄水池
            if (left <= right){
                continue;
            }

            List<Integer> list = new ArrayList<>();
            list.add(left);
            list.add(right);

            boolean isSuccess = false;
            int index = 0; // 蓄水池右边界的索引

            for (int j = i + 2; j < nums.length; j++){
                int height = nums[j];
                list.add(height);
                if (height > right){
                    right = height;
                    index = list.size() - 1;
                    isSuccess = true;
                }
                if (height >= left){
                    break;
                }
            }

            if (isSuccess){
                int height  = Math.min(list.get(0),list.get(index));
                int count = 0;
                for (int k = 1; k < index; k++){
                    count += (height - list.get(k));
                }
                res = Math.max(res,count);
                if (res == count){
                    indexLeft = i;
                    indexRight = index + i;
                }
            }
        }

        if (res == 0){
            System.out.println(0);
        }else {
            System.out.println(indexLeft + " " + indexRight + ":" + res);
        }

    }

    /*
    逻辑分析
    推荐这个代码 思路清晰
     */
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int[] mountains = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

        // 最小山峰
        int min = Arrays.stream(mountains).min().getAsInt();

        // 最大面积
        int max = 0;
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i < mountains.length; i++){
            int left = mountains[i];
            // 最小山峰为边界，无法构成蓄水池
            if (left == min){
                continue;
            }
            for (int j = i+2; j < mountains.length; j++){
                int right = mountains[j];
                // 最小山峰为边界，无法构成蓄水池
                if (right == min){
                    continue;
                }
                // 蓄水池的高度为左右边界最小值
                int height = Math.min(left,right);
                int area = 0;
                for (int k = i + 1; k <j;k++){
                    int areaOne = height - mountains[k];
                    if (areaOne > 0){
                        area += areaOne;
                    }
                }

                if (area >max){
                    max = area;
                    maxLeft = i;
                    maxRight = j;
                }else if (area == max && (maxRight - maxLeft) > (j-i)){
                    // 如果出现多个满足条件的边界，选取距离最近的一组边界
                    maxLeft = i;
                    maxRight = j;
                }
            }
        }

        System.out.println(max == 0 ? 0 : maxLeft + " " + maxRight + ":" + max);

    }

}
