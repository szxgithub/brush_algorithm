package com.leetcode.hot100.easy;

import java.util.Stack;

class ListNode{
    int val;
    ListNode next;

    ListNode(){

    }
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

/**
 * 合并两个有序链表
 */
public class ItemTwentyOne {

    //递归  时间复杂度O(m+n) 其中m ,n 为两个链表的长度，因为每次调用都会去掉两个链表的头结点，时间复杂度取决于合并后的长度
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){

        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }else if(list1.val > list2.val){
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }else {
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }
    }

    //迭代  设置一个哨兵，
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2){

        //哨兵
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;

        //当两个链表均不为空时，判断哪个链表头结点值最小，将较小的值放入合并链表中
        while (list1!=null && list2 != null){
            if (list1.val < list2.val){
                prev.next = list1;
                list1 = list1.next;
            }else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        //将链表末尾指针直接指向还未合并完的链表
        prev.next = list1 == null ? list2:list1;

        return prehead.next;
    }
}
