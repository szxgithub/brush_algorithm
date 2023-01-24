package com.leetcode.hot100.hard;

import java.util.PriorityQueue;

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
 * 合并K个升序链表
 */
public class ItemTwentyThree {

    //顺序合并
    public ListNode mergeKLists(ListNode[] lists){

        ListNode ans = null;
        for (int i = 0; i<lists.length;i++){
            ans = mergeTwoLists(ans,lists[i]);
        }
        return ans;

    }

    private ListNode mergeTwoLists(ListNode ans, ListNode list) {

        if (ans == null || list == null){
            return ans !=null? ans:list;
        }

        ListNode pre = new ListNode(0);
        ListNode tail = pre;
        while (ans != null && list !=null){
            if(ans.val>list.val){
                tail.next = list;
                list = list.next;
            }else{
                tail.next = ans;
                ans = ans.next;
            }
            tail = tail.next;
        }

        tail.next = (ans != null? ans:list);

        return pre.next;
    }

    //使用优先队列
    class Status implements Comparable<Status>{

        int val;
        ListNode ptr;

        Status(int val, ListNode ptr){
            this.val = val;
            this.ptr = ptr;
        }

        @Override
        public int compareTo(Status o) {
            return this.val - o.val;
        }
    }

    PriorityQueue<Status> queue = new PriorityQueue<Status>();

    public ListNode mergeKLists2(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status status = queue.poll();
            tail.next = status.ptr;
            tail = tail.next;
            if (status.ptr.next != null) {
                queue.offer(new Status(status.ptr.next.val, status.ptr.next));
            }
        }
        return head.next;
    }

}
