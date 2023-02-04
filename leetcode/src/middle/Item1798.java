package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Item1798 {

    /*
    你能构造出连续值的最大数目

    请返回从0开始（包括0），你最多能构造出多少个连续整数

    数学思想
    如果可以构造0-m数字，则构建下一个目标数字m+1,需要找到一个小于等于m+1的数

     */

    public int getMaximum(int[] coins){

        // 一开始只能构造出0
        int m = 0;
        Arrays.sort(coins);

        for (int num : coins){
            if (num > m+1){ // coins已经排序 后面逐渐增大
                break; //无法构造出m+1，继续循环没有意义了
            }
            m += num;
        }
        return m+1;

    }

    public static void main(String[] args) {
        Item1798 item1798 = new Item1798();

        int[] coins = {1,1,1,4};
        int maximum = item1798.getMaximum(coins);
        System.out.println(maximum);
    }

}
