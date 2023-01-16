package com.leetcode.hot100.hard;

import java.util.*;
import java.util.function.ToIntFunction;

public class Item239 {

    /**
     *
     * 滑动窗口最大值
     *
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回 滑动窗口中的最大值 。
     *
     * */

    /**
     *
     * 暴力搜索  超时
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= nums.length - k; i++){
            for (int j = i; j < i + k && j < nums.length; j++){
                pq.add(nums[j]);
                if (pq.size() == k){
                    res.add(pq.poll());
                    pq.clear();
                }
            }
        }

        return res.stream().mapToInt(value -> value).toArray();
    }

    /**
     *
     * 实现一个单调队列结构
     *
     * 1,3,-1,-3,5,3,6,7
     *
     */
    class MonotonicQueue{
        LinkedList<Integer> maxq =new LinkedList<>();
        public void push(int n){
            while (!maxq.isEmpty() && maxq.getLast() < n){
                maxq.pollLast();
            }
            maxq.addLast(n);
        }

        public int max(){
            return maxq.getFirst();
        }

        public void pop(int n){
            if(n == maxq.getFirst()){
                maxq.pollFirst();
            }
        }
    }

    public int[] maxSlidingWindow2(int[] nums, int k){

        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){
            if (i < k-1){
                window.push(nums[i]);
            }else {
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i<res.size(); i++){
            arr[i] = res.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {

        Item239 item239 = new Item239();

        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = item239.maxSlidingWindow2(nums, k);
        System.out.println(Arrays.toString(ints));

    }

}
