package middle;

public class Item1669 {

    /**
     *
     * 合并两个链表
     *
     * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
     *
     * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
     *
     */

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2){

        int index = 0;

        ListNode head1  = list1;
        ListNode prev = null;
        ListNode next = null;
        while (list1 != null){

            // 找到a下标前一个节点
            if(index == a - 1){
                prev = list1;
            }
            // 找到b下标的后一个节点
            if (index == b+1){
                next = list1;
                break;
            }

            list1 = list1.next;
            index++;
        }

        ListNode head2 = list2;
        while (list2.next != null){
            list2 = list2.next;
        }

        prev.next = head2;
        list2.next = next;

        return head1;

    }

    public static void main(String[] args) {

        ListNode list1 = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);

        list1.next = listNode1;
        listNode1.next = listNode2;

        ListNode list2 = new ListNode(1000000);
        ListNode node1 = new ListNode(1000001);
        ListNode node2 = new ListNode(1000002);
        ListNode node3 = new ListNode(1000003);

        list2.next = node1;
        node1.next = node2;
        node2.next = node3;

        Item1669 item1669 = new Item1669();
        ListNode node = item1669.mergeInBetween(list1, 1, 1, list2);

        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }


    }

}
