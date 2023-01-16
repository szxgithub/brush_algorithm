package 从尾到头打印链表;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;


class ListNode{
	int val;
	ListNode next = null;
	
	ListNode(int val){
		this.val = val;
	}
}

public class Main {
	
	public static Stack<Integer> st = new Stack<>();
	
	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);
		
		ArrayList<Integer> list2 = printListFromTailToHead(root);
		System.out.println(list2);
	}
	
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if(listNode==null){
			ArrayList<Integer> list = new ArrayList<>();
			return list;
		}
		
		//定义一个栈
		Deque<Integer> stack = new ArrayDeque<>();
		while(listNode!=null){
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		ArrayList<Integer> list = new ArrayList<>();
		while(!stack.isEmpty()){
			list.add(stack.pop());	//出栈，并添加到list
		}
		return list;
    }
	
}
