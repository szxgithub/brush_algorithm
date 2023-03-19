package od2023.onehundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    /*

    单向链表中间节点(寻找链表的中间结点)

    求单向链表中间的节点值，如果奇数个节点取中间，偶数个取偏右边的那个值

输入：
00010 4
00000 3 -1
00010 5 12309
11451 6 00000
12309 7 11451
输出：6

输入：
10000 3
76892 7 12309
12309 5 -1
10000 1 76892
输出:7

     */


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");

        // 头结点地址
        String headAddr = s[0];

        // 后续输入的节点数
        Integer N = Integer.valueOf(s[1]);

        HashMap<String,String[]> nodes = new HashMap<>();
        for (int i = 0; i<N; i++){
            String[] tmp = sc.nextLine().split(" ");
            nodes.put(tmp[0],new String[]{tmp[1], tmp[2]});
        }

        // 存放节点的值
        List<String> valList = new ArrayList<>();
        String[] head = nodes.get(headAddr);
        while (head != null){
            String val = head[0];
            String next = head[1];
            valList.add(val);
            head = nodes.get(next);
        }

        int mid = valList.size() / 2;
        System.out.println(valList.get(mid));

    }

}
