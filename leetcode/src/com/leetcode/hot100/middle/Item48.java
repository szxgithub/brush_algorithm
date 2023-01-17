package com.leetcode.hot100.middle;

public class Item48 {

    /**
     * 旋转图像
     *
     * 给定一个nxn的二维矩阵matrix表示一个图像，请你将图像顺时针选择90度
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵
     *
     * @param matrix
     */


    /**
     * 使用辅助数组
     * @param matrix
     */
    public void rotate(int[][] matrix){

       int n = matrix.length;
       int[][] matrix_new = new int[n][n];
       for (int i = 0; i < n; ++i){
           for (int j = 0; j < n; ++j){
               matrix_new[j][n-i-1] = matrix[i][j];
           }
       }

       for (int i = 0; i < n; ++i){
           for (int j = 0; j < n; ++j){
               matrix[i][j] = matrix_new[i][j];
           }
       }

    }


    /***
     * 原地旋转
     * @param matrix
     */
    public void rotate2(int[][] matrix){
        int n = matrix.length;
        for (int i = 0; i < n/2; ++i){
            for (int j = 0; j < (n+1)/2; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    /**
     * 翻转
     * @param matrix
     */
    public void rotate3(int[][] matrix){

        int n = matrix.length;

        // 水平翻转
        for (int i = 0; i<n/2; ++i){
            for (int j = 0; j< n;++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }

        // 主对角线翻转
        for (int i = 0; i<n; ++i){
            for (int j = 0;j<i;++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
}
