package od2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main7 {

    /*

    天然蓄水库

    双指针

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] s = str.split(" ");

        int[] nums = new int[s.length];

        for (int i =0 ; i<nums.length; i++){
            nums[i] = Integer.parseInt(s[i]);
        }

        // 蓄水量的高度为两边届的最小值， 如果有多个满足条件的边界，选取距离最近的一组边界

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

}
