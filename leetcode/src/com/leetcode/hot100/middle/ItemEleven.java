package com.leetcode.hot100.middle;

/*
 盛水最多的容器
 */
public class ItemEleven {

     //暴力搜索
    public int maxArea(int[] height){

        int maxarea = 0;
        for(int i = 0; i<height.length; i++){
            for(int j = i+1; j<height.length; j++){
                maxarea = Math.max(maxarea, Math.min(height[i],height[j])*(j-i));
            }
        }

        return maxarea;

    }

    //双指针法
    public  int maxArea2(int[] height){

        int maxArea = 0, i=0, r = height.length-1;
        while (i<r){
            maxArea = Math.max(maxArea, Math.min(height[i], height[r]) * (r - i));
            if(height[i] < height[r]){
                i++;
            }else {
                r--;
            }
        }
        return maxArea;
    }

}
