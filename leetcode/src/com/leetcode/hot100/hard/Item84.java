package com.leetcode.hot100.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Item84 {

    /**
     *
     * 柱状图中最大的矩形
     *
     * 给定n个非负整数，用来表示柱状图中各个柱子的高度，每个柱子彼此相邻，且宽度为1
     *
     * 求在该柱状图中，能够勾勒出来的矩形最大面积
     *
     */


    /**
     * 枚举高
     * 时间复杂度太高 会超时
     *
     * @param heights
     * @return
     */
    public int  largestRectangleArea(int[] heights){

        int length = heights.length;

        int ans = 0;

        for (int i = 0; i < length; i++){

            // 枚举高
            int height = heights[i];
            int left = i, right = i;

            // 确定左右边界
            while(left - 1 >= 0 && heights[left-1] >= height){
                left--;
            }

            while (right + 1 < length && heights[right + 1 ] >= height){
                right++;
            }

            // 计算面积
            ans = Math.max(ans,(right - left + 1)*height);

        }

        return ans;

    }

    public int largestRectangleArea2(int[] heights){
        int len = heights.length;
        if (len == 0){
            return 0;
        }

        if (len == 1){
            return heights[0];
        }

        int area = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i= 0; i<len; i++){
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]){
                int height = heights[stack.removeLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == height){
                    stack.removeLast();
                }
                int width;
                if (stack.isEmpty()){
                    width = i;
                }else {
                    width = i - stack.peekLast() - 1;
                }

                area = Math.max(area,width*height);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()){
            int height = heights[stack.removeLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == height){
                stack.removeLast();
            }

            int width;
            if (stack.isEmpty()){
                width = len;
            }else {
                width = len - stack.peekLast() - 1;
            }
            area = Math.max(area,width*height);
        }

        return area;
    }

}
