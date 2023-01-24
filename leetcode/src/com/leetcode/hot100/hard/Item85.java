package com.leetcode.hot100.hard;

import java.util.Deque;
import java.util.LinkedList;

public class Item85 {

    /**
     * 最大矩形
     *
     * 给定一个仅包含0 和 1、大小为rows x cols的 二维二进制矩阵，找出只包含1的最大矩形，并返回其面积
     *
     * @param matrix
     * @return
     */


    /**
     *
     * 暴力搜索方法
     *
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix){
        int m = matrix.length;
        if (m == 0){
            return 0;
        }

        int n = matrix[0].length;

        int[][] left = new int[m][n];

        // 计算出矩阵的每个元素的左边连续 1 的数量
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '1'){
                    left[i][j] = (j == 0 ? 0 : left[i][j-1]) + 1;
                }
            }
        }


        //  对于矩阵中任意一个点，我们枚举以该点为右下角的全 1 矩形。
        int ret = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j <n; j++){
                if (matrix[i][j] == '0'){
                    continue;
                }
                int width = left[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--){
                    width = Math.min(width,left[k][j]);
                    area = Math.max(area, (i-k+1)*width);
                }
                ret = Math.max(ret,area);
            }
        }

        return ret;
    }

    public int maximalRectangle2(char[][] matrix){
        int m = matrix.length;
        if (m == 0){
            return 0;
        }

        int n = matrix[0].length;

        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '1'){
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;

        for (int j = 0; j < n; j++){
            int[] up = new int[m];
            int[] down = new int[m];

            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i <m; i++){
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]){
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            stack.clear();

            for (int i = m - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < m; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                ret = Math.max(ret, area);
            }
        }

        return ret;

    }

}
