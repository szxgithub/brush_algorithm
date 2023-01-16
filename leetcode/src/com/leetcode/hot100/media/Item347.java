package com.leetcode.hot100.media;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 前K个高频元素
 *
 */
public class Item347 {

    private class Freq implements Comparable<Freq>{
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }


        @Override
        public int compareTo(Freq another) {
            if(freq< another.freq){
                return -1;
            }else if(freq > another.freq){
                return 1;
            }else {
                return 0;
            }
        }
    }

    //算法时间复杂度 nlogk
    public int[] topKFrequent(int[] nums, int k){

        //先统计频次
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0;i<nums.length;i++){
            if(map.get(nums[i]) == null){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }

        //利用优先队列求出前K个元素
        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();
        for (int key : map.keySet()){
            if ( priorityQueue.size() < k){
                priorityQueue.add(new Freq(key,map.get(key)));
            }else if(map.get(key) > priorityQueue.peek().freq){
                priorityQueue.remove();
                priorityQueue.add(new Freq(key,map.get(key)));
            }
        }

        //将这前K个元素放进一个list返回
        LinkedList<Integer> res = new LinkedList<>();
        while (!priorityQueue.isEmpty()){
            res.add(priorityQueue.poll().e);
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

}
