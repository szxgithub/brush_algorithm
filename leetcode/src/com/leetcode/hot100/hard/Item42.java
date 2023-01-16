package com.leetcode.hot100.hard;

import java.awt.*;
import java.util.Stack;

public class Item42 {

    /**
     * 接雨水
     * 给定n个非负整数表示每个宽度为1的柱子的高度图，计算按此排列的柱子之后，下雨之后能接多少雨水
     *
     * @param height
     * @return
     */
    public int trap(int[] height){
        int sum = 0;
        int max = getMax(height); //找到最大高度，以便遍历
        for (int i = 1; i<=max; i++){
            boolean isStart = false;
            int temp_sum = 0;
            for (int j = 0; j<height.length;j++){
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

    private int getMax(int[] height){
        int max = 0;
        for (int i = 0; i< height.length;i++){
            if (height[i] > max){
                max = height[i];
            }
        }
        return max;
    }

    public int trap2(int[] height){
        int sum = 0;

        // 最两端的列不用考虑，因为一定不会有水，所以下标从1到length-2
        for (int i = 1; i<height.length - 1;i++){
            int max_left = 0;
            // 找出左边最高
            for (int j = i - 1; j >= 0; j--){
                if (height[j] > max_left){
                    max_left = height[j];
                }
            }

            int max_right = 0;
            for (int j = i+1;j<height.length;j++){
                if (height[j] > max_right){
                    max_right = height[j];
                }
            }

            // 找出两端较小的
            int min = Math.min(max_left,max_right);
            if (min > height[i]){
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 动态规划
     *
     * @param height
     * @return
     */
    public int trap3(int[] height){
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
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
