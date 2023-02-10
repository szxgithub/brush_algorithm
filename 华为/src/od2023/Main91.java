package od2023;

import java.util.Arrays;
import java.util.Scanner;

public class Main91 {

    /*

    最大平分数组

    给定一个数组nums, 将元素分为若干个组，使得每组和相等，求出满足条件得所有分组中，组内元素和得最小值

    第一行输入m 接着输入m个数，表示此数组 数据范围 1<=M<=50  1<=nums[i] <= 50

    //todo


     */

    public static boolean isSuccess = false;

    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
       int m = sc.nextInt();
       int[] ints = new int[m];
       for (int i =0; i<m; i++){
           ints[i] = sc.nextInt();
       }

        Arrays.sort(ints);
        int min = ints[ints.length-1];      //最小平均值为数组最大值
        int max = Arrays.stream(ints).sum();    //最大平均值为数组总和

        int res = 0;
        for (int i=min; i<max; i++){
            if(max%i == 0){     //满足整除的情况下才能进行平分
                int[] temp = Arrays.copyOf( ints, ints.length);
                check( temp, 0, 0,  i);
                if(isSuccess){
                    res = i;
                    break;
                }
            }
        }

        System.out.println(res);
    }

    /**
     *
     * @param nums      数字数组
     * @param index     数字索引
     * @param count     数字和
     * @param average   平均值
     */
    public static void check(int[] nums, int index, int count, int average) {

        if(Arrays.stream(nums).sum() == 0){
            isSuccess = true;
        }else {
            for(int i=index; i<nums.length; i++){

                int n = nums[i];    //当前索引的数字
                if(n == 0){
                    continue;
                }

                if(count + n <= average){
                    nums[i] = 0;    //使用过的数字需要置为0
                    //需要判断是否满足平均值，如满足，index和count都需要初始化为0
                    check( nums, count + n == average ? 0 : index + 1, count + n == average ? 0 : count + n, average);
                    nums[i] = n;    //不满足的情况下需要回退
                }
            }
        }
    }

}
