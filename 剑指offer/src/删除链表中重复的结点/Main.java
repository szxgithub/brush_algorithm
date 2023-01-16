package 删除链表中重复的结点;

class ListNode{
	int val;
	ListNode next = null;
	ListNode(int val){
		this.val = val;
	}
}
public class Main {
	public static ListNode deleteDuplication(ListNode pHead){
		if(pHead==null || pHead.next==null){
			return pHead;
		}
		ListNode pre = null;
		ListNode cur = pHead;
		ListNode post = pHead.next;
		
		boolean needDelete = false;
		while(post!=null){
			if(cur.val==post.val){
				needDelete = true;
				post = post.next;
			}else if(needDelete && !(cur.val==post.val)){
				if(pre==null)
					pHead = post;
				else
					pre.next = post;
				cur = post;
				post = post.next;
				needDelete = false;
			}else{
				pre = cur;
                cur = post;
                post = post.next;
			}
		}
		if(needDelete && pre!=null)
            pre.next = null;
        else if(needDelete && pre==null)
            pHead = null;
        return pHead;
	}
	
	public static void main(String[] args) {
		

	}
}
