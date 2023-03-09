package com.leetcode.hot100.hard;

import java.awt.*;
import java.util.Arrays;
import java.util.Stack;

public class Item42 {

    /**
     * 接雨水
     * 给定n个非负整数表示每个宽度为1的柱子的高度图，计算按此排列的柱子之后，下雨之后能接多少雨水
     *
     * @param height
     * @return
     */

    /*
    暴力破解，通过率100%
     */
    public int trap1(int[] height){
        int n = height.length;
        int res = 0;

        // 数组充当备忘录
        int[] l_max = new int[n];
        int[] r_max = new int[n];

        l_max[0] = height[0];
        r_max[n-1] = height[n-1];

        for (int i = 1; i < n; i++){
            l_max[i] = Math.max(l_max[i-1],height[i]);
        }
        for (int i = n-2; i >= 0; i--){
            r_max[i] = Math.max(r_max[i+1],height[i]);
        }

        for (int i = 1; i <n; i++){
            res += Math.min(l_max[i],r_max[i]) - height[i];
        }
        return res;
    }


    /*
    按行求解
    先求高度为1的水，再求高度为2的水，再求高度为3的水。。。

    该方法通过测试用例99%
     */
    public int trap2(int[] height){
        int sum = 0;
        int max = Arrays.stream(height).max().getAsInt();
        for (int i = 1; i <= max; i++){
            // 标记是否开始更新
            boolean isStart = false;
            int temp_sum = 0;
            for (int j = 0; j < height.length; j++){
                if (isStart && height[j] < i){
                    temp_sum++;
                }
                if (height[j] >= i){
                    sum = sum + temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }

    /**
     * 双指针
     *
     * @param height
     * @return
     */
    public int trap4(int[] height){

        int sum = 0;

        int max_left = 0;

        int[] max_right = new int[height.length];

        for (int i = 1; i<height.length - 1; i++){
            max_left = Math.max(max_left,height[i-1]);
            int min = Math.min(max_left,max_right[i]);
            if (min > height[i]){
                sum = sum  + (min - height[i]);
            }
        }

        return sum;

    }

    public int trap6(int[] height){
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        int current = 0;
        while (current < height.length){
            // 如果栈不为空，且当前指向的高度大于栈顶高度就一直循环
            while (!stack.isEmpty() && height[current] > height[stack.peek()]){
                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                int dstance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + dstance*(min - h);
            }

            stack.push(current);
            current++;
        }
        return sum;
    }

}
