package com.leetcode.hot100.media;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache1 extends LinkedHashMap<Integer,Integer> {

    private int capacity;

    public LRUCache1(int capacity){
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {

        return size() > capacity;
    }
}
