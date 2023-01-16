package com.leetcode.hot100.media;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
 * 删除链表的倒数第n个结点， 并返回链表的头结点
 */
public class ItemNineteen {

    public static ListNode removeNthFromEnd(ListNode head, int n){
        int count1 = 1;
        //保留头指针
        ListNode p1 = head;
        while (head.next != null){
            head = head.next;
            count1++;
        }

        int count2 = 1;

        //再次复制头指针
        ListNode p2 = p1;

        //如果删除的是头指针
        if(count1 == n){
            return p1.next;
        }

        while (p1.next!=null){
            count2++;
            if (count2 == count1-n+1){
                p1.next = p1.next.next;
                break;
            }
            p1 = p1.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        /*ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;

        ListNode listNode = removeNthFromEnd(listNode1, 2);
        System.out.println(listNode);*/

        ListNode result = removeNthFromEnd2(listNode1, 1);
        System.out.println(result);
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n){
        //定义一个哑结点
        ListNode dummy = new ListNode(0,head);
        //获取链表的长度
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i< length - n + 1; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;

    }

    private static int getLength(ListNode head) {
        int length = 0;
       while (head!=null){
            length++;
            head = head.next;
       }
       return length;
    }

    //栈方法
    public ListNode removeNthFromEnd3(ListNode head, int n){
        ListNode dummy = new ListNode(0,head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i<n; i++){
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;

    }

    //快慢指针
    public ListNode removeNthFromEnd4(ListNode head, int n){
        //定义一个哑结点，无需对头结点进行特殊判断了
        ListNode dummy = new ListNode(0,head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i< n; i++){
            first = first.next;
        }
        //两个结点同时前进，直到快结点停止
        while (first!=null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }


}
