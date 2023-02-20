package od2022I;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {


    /**
     *
     * 太阳能板最大面积
     *
     * 输入为无序的柱子的高度，输出可以支持最大的面积
     *
     *
     * */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){

            String str = sc.nextLine();

            String[] strArr = str.split(",");

            int[] nums = new int[strArr.length];
            for (int i = 0; i < nums.length; i++){
                nums[i] =  Integer.parseInt(strArr[i]);
            }

            Arrays.sort(nums);

            int max = 0;
            for (int i = 0; i < nums.length; i++){

                if (max < nums[i]*(nums.length - 1 - i)){
                    max = nums[i]*(nums.length - 1 -i);
                }
            }

            System.out.println(max);

        }


    }

}
