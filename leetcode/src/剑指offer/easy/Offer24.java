package 剑指offer.easy;

public class Offer24 {

    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode listNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

}
