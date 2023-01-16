package com.leetcode.hot100.easy;

import java.util.List;
import java.util.Stack;

/**
 * 反转链表  比较好的是双指针算法
 *
 * 给你单链表的头结点，反装链表，并返回反转后的链表
 */

public class Item206 {

    private class ListNode{
        int val;
        ListNode next;

        public ListNode(){

        }

        public ListNode(int val){
            this.val = val;
        }

        public ListNode(int val, ListNode listNode){
            this.val = val;
            this.next = listNode;
        }
    }

    // 利用一个栈  时间复杂度过高
    public ListNode reverseList(ListNode head){

        if (head == null){
            return null;
        }

        Stack<ListNode> listNodes = new Stack<>();

        while (head!=null){

            listNodes.push(head);
            head = head.next;

        }

        ListNode dummyNode = new ListNode();
        head = listNodes.pop();
        dummyNode.next = head;

        while (!listNodes.isEmpty()){
            head.next = listNodes.pop();
            head = head.next;
            head.next = null;
        }

        return dummyNode.next;

    }

    //双指针 空间复杂度只有 O(1) 推荐
    public ListNode reverseList2(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while (curr!=null){
            //保存下一个结点
            ListNode next = curr.next;
            //当前结点指向前一个结点
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }


}
