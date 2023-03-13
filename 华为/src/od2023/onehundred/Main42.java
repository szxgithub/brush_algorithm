package od2023.onehundred;

import java.util.Arrays;
import java.util.Scanner;

public class Main42 {

    /*
    简单的自动曝光
    一个图像有n个像素点，存在一个长度为n的数组里，每个像素点的取值范围是[0,255]的正整数
    请你给图像每个像素点值加上一个整数K，得到新得图像，使得新图像的像素平均值最接近中位数128

    如有多个整数k都满足，输出最小的那个K

    输入描述：
        n个整数，中间用空格分开
    输出描述：
        一个整数K
    备注：
        1 <= n <= 100


     */

    /*
    逻辑分析

    因为像素都在[0,255]范围内，
    如果想让0接近中位，应该加上128，如果想让255接近中位，赢减去127
    因此K的范围应该在-127-128之间，遍历该范围，将遍历值加到像素点上，求平均值
     */
    public int getResult(Integer[] arr){
        int len = arr.length;
        double minDiff = Integer.MAX_VALUE;
        Integer ans = null;

        for (int k = -127; k <= 128; k++){
            double sum = 0;
            for (Integer val : arr){
                int newVal = val + k;
                newVal = Math.max(0,Math.min(newVal,255));
                sum += newVal;
            }

            double diff = Math.abs(sum/len - 128);
            if (diff < minDiff){
                minDiff = diff;
                ans = k;
            }else if (diff == minDiff && ans != null){
                ans = Math.min(ans,k);
            }
        }

        return ans;
    }

}
