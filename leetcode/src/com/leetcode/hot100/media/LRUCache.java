package com.leetcode.hot100.media;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Lru缓存 思路比较清晰的代码
 */
public class LRUCache {

    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode(){

        }

        public DLinkedNode(int _key, int _value){
            this.key = _key;
            this.value = _value;
        }
    }

    private HashMap<Integer,DLinkedNode>cache = new HashMap<Integer,DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity){
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if (node == null){
            return  -1;
        }
        //如果key存在，先通过哈希表定位，再移动到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value){
        DLinkedNode dLinkedNode = cache.get(key);
        if (dLinkedNode == null){
            //如果key不存在就创建一个新结点
            DLinkedNode newNode = new DLinkedNode(key, value);
            //添加进哈希表
            cache.put(key,newNode);
            //结点添加进链表
            addToHead(newNode);
            size++;
            //如果超出容量,删除链表的尾部结点
            if(size > capacity){
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }else{

            dLinkedNode.value = value;
            moveToHead(dLinkedNode);

        }
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }


    private void moveToHead(DLinkedNode node) {
        //从链表中先移除
        removeNode(node);
        //再添加进来
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
       node.prev = head;
       node.next = head.next;
       head.next.prev = node;
       head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


}
