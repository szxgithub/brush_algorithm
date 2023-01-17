package com.leetcode.hot100.middle;

import java.util.*;

/**
 *
 * 查找和最小的K对数字
 *
 */
public class Item373 {

    private class Ksum implements Comparable<Ksum>{
        List<Integer> list;
        int sum;

        public Ksum(){

        }

        public Ksum(List<Integer> list, int sum){
            this.list = list;
            this.sum = sum;
        }

        @Override
        public int compareTo(Ksum anotherSum) {
            if (sum > anotherSum.sum){
                return 1;
            }else if (sum < anotherSum.sum){
                return -1;
            }else {
                return 0;
            }
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k){
        /*
        将和最小的k对数字放入优先队列中，再输出 算法复杂度最低
         */

        //统计所有整数对的和
        List<Ksum> ksumList= new ArrayList<>();
        for (int i = 0;i<nums1.length;i++){
            for (int j = 0;j<nums2.length;j++){
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(nums1[i]);
                integers.add(nums2[j]);
                int tmpSum = nums1[i] + nums2[j];
                Ksum ksum = new Ksum(integers,tmpSum);
                ksumList.add(ksum);
            }
        }

        PriorityQueue<Ksum> priorityQueue = new PriorityQueue<>();

        for (Ksum ksum : ksumList){
            if (priorityQueue.size() < k){
                priorityQueue.add(ksum);
            }else if(priorityQueue.peek().sum > ksum.sum){
                priorityQueue.remove();
                priorityQueue.add(ksum);
            }
        }

        List<List<Integer>> kSmallestPairs = new ArrayList<>();
        while (!priorityQueue.isEmpty()){
            kSmallestPairs.add(priorityQueue.poll().list);
        }

        return kSmallestPairs;
    }

}
