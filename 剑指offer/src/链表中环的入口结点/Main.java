package 链表中环的入口结点;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {
	public static void main(String[] args) {
		
	}
	
	public ListNode EntryNodeOfLoop(ListNode pHead)
    {
		ListNode runner = pHead;
		ListNode walker = pHead;
		
		while(runner!=null && runner.next!=null){
			runner = runner.next.next;
			walker = walker.next;
			if(runner==walker)
				break;
		}
		
		if(runner==null || runner.next==null)
			return null;
		
		walker = pHead;
		while(runner!=walker){
			runner = runner.next;
			walker = walker.next;
		}
		return runner;
		
    }
}
