package com.leetcode.hot100.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Item23 {

    /**
     *
     * 合并K个有序链表
     * 给你一个链表数组，每个链表都已经升序排列
     * 请将所有链表合并到一个升序链表中，返回合并后的链表
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        for(int i = 0; i<lists.length; i++){
            ListNode listNode = lists[i];
            while (listNode != null){
                listNodes.add(new ListNode(listNode.val));
                listNode = listNode.next;
            }
        }

        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val){
                    return -1;
                }else if (o1.val > o2.val){
                    return 1;
                }else {
                    return 0;
                }
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        ListNode[] listNodesArr = listNodes.toArray(new ListNode[]{});
        Arrays.sort(listNodesArr, comparator);

        for (int i = 0; i< listNodesArr.length-1;i++){
            listNodesArr[i].next = listNodesArr[i+1];
        }
        if (listNodesArr.length > 0){
            return listNodesArr[0];
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode11 = new ListNode(1);
        ListNode listNode33 = new ListNode(3);
        ListNode listNode44 = new ListNode(4);
        listNode11.next = listNode33;
        listNode33.next = listNode44;

        ListNode listNode2 = new ListNode(2);
        ListNode listNode6 = new ListNode(6);
        listNode2.next = listNode6;

        ListNode[] listNodes = new ListNode[]{listNode1,listNode11,listNode2};

        ListNode listNode = mergeKLists(listNodes);
        System.out.println(listNode);
    }

    /**
     * 合并两个有序链表
     */
    public ListNode mergeTwoLists(ListNode a, ListNode b){
        if (a == null || b == null){
            return a != null ? a : b;
        }

        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null){
            if (aPtr.val < bPtr.val){
                tail.next = aPtr;
                aPtr = aPtr.next;
            }else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }


    public ListNode mergeKLists2(ListNode[] lists){
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++){
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    public ListNode mergeKLists3(ListNode[] lists){
        return merge(lists,0,lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r){
        if(l==r){
            return lists[l];
        }
        if (l > r){
            return null;
        }
        int mid = (l+r) >> 1;
        return mergeTwoLists(merge(lists,l,mid),merge(lists,mid+1,r));
    }

    /**
     * 使用优先队列合并
     */
    class Status implements Comparable<Status>{
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr){
            this.val = val;
            this.ptr = ptr;
        }

        @Override
        public int compareTo(Status status){
            return this.val - status.val;
        }
    }

    PriorityQueue<Status> queue = new PriorityQueue<Status>();

    public ListNode mergeKLists4(ListNode[] lists){

        // 每个链表结点入队
        for(ListNode node : lists){
            if (node != null){
                queue.offer(new Status(node.val,node));
            }
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;

        while (!queue.isEmpty()){
            Status poll = queue.poll();
            tail.next = poll.ptr;
            tail = tail.next;
            if (poll.ptr.next != null){
                queue.offer(new Status(poll.ptr.next.val,poll.ptr.next));
            }
        }

        return head.next;

    }


}
