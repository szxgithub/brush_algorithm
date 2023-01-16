package 链表中倒数第K个结点;


public class Main {
	public ListNode FindKthToTail(ListNode head,int k) {
		ListNode p,q;
		p=q = head;
		int i=0;
		for(;p!=null;i++){
			if(i>=k){
				q = q.next;
			}
			p = p.next;
		}
		return i<k?null:q;
    }	
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
