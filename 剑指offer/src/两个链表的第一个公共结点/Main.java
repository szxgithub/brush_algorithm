package 两个链表的第一个公共结点;

import java.util.HashMap;

class ListNode{
	int val =0;
	ListNode next = null;
	
	ListNode(int val){
		this.val = val;
	}
}

public class Main {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2){
		ListNode current1 = pHead1;
		ListNode current2 = pHead2;
		
		HashMap<ListNode,Integer> hashMap = new HashMap<>();
		while(current1!=null){
			hashMap.put(current1, null);
			current1 = current1.next;
		}
		
		while(current2!=null){
			if(hashMap.containsKey(current2)){
				return current2;
			}
			current2 = current2.next;
		}
		return null;
	}
}
