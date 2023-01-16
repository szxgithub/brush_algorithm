package 删除链表中重复的结点;

import java.util.Hashtable;

public class Main2 {
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(2);
		n1.next.next = new ListNode(3);
		n1.next.next.next = new ListNode(3);
		n1.next.next.next.next = new ListNode(4);
		n1.next.next.next.next.next = new ListNode(4);
		n1.next.next.next.next.next.next = new ListNode(5);
		
		ListNode res = deleteDuplication(n1);
		while(res!=null){
			System.out.println(res.val);
			res = res.next;
		}
	}
	
	public static ListNode deleteDuplication(ListNode pHead){
		
		Hashtable<Integer,Integer> table = new Hashtable<>(); 
		
		ListNode head = pHead;
		ListNode tmp = pHead;
		ListNode pre = pHead;
		
		while(tmp!=null){
			if(table.containsKey(tmp.val)){
				pre.next = tmp.next;
			}else{
				table.put(tmp.val, 1);
				pre = tmp;
			}
			tmp = tmp.next;
		}
		
		return head;
	}
}
