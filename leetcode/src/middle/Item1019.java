package middle;

import java.util.*;

public class Item1019 {

    /*
    链表中的下一个更大节点
     */
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list =  new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            for (int j = i+1; j < list.size(); j++){
                if (list.get(i) < list.get(j)){
                    ans[i] = list.get(j);
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Item1019 item1019 = new Item1019();
        ListNode listNode2 = new ListNode(2);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode5 = new ListNode(5);

        listNode2.next = listNode7;
        listNode7.next = listNode4;
        listNode4.next = listNode3;
        listNode3.next = listNode5;

        int[] ints = item1019.nextLargerNodes(listNode2);
        System.out.println(Arrays.toString(ints));
    }

    //2,7,4,3,5
    public int[] nextLargerNodes3(ListNode head) {
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next){
            ++n; // 确定返回值的长度
        }
        int[] ans = new int[n];
        Deque<int[]> st = new ArrayDeque<int[]>(); // 单调栈（节点值，节点下标）
        int i = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            while (!st.isEmpty() && st.peek()[0] < cur.val){
                ans[st.pop()[1]] = cur.val; // 用当前节点值更新答案
            }
            st.push(new int[]{cur.val, i++});
        }
        return ans;
    }
}
