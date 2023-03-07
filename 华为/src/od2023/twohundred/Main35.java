package od2023.twohundred;

import java.util.*;

public class Main35 {

    /*

    创建二叉树

    1、创建值为-1的根结点，根节点在第0层
    2、然后根据operations依次添加节点，operations[i] = [height,index] 表示对第height层的第index个节点node，添加值为i的子节点
    height、index均从0开始计数

    输入描述：
        operations
    输出描述：
        根据返回树根节点，按照层序遍历二叉树打印的结果


     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        // 处理输入字符串
        //调用getResult方法
    }

    public static String getResult(Integer[][] opeartions){

        // 创建树根节点
        Node head = new Node(-1);
        List<Node> level0 = new ArrayList<>();
        level0.add(head);

        List<List<Node>> tree = new ArrayList<>();
        tree.add(level0);

        for (int i = 0; i < opeartions.length; i++){
            // 第height层
            int height = opeartions[i][0];
            // 第index节点
            int index = opeartions[i][1];
            if (tree.size() <= height + 1){
                tree.add(new ArrayList<>());
            }

            // 添加值为i的节点
            Node ch = new Node(i);
            tree.get(height + 1).add(ch);

            // 找出要插入节点的父节点
            Node fa = tree.get(height).get(index);
            if (fa.lc == null){
                fa.lc = ch;
            }else if (fa.rc == null){
                fa.rc = ch;
            }
        }

        // 遍历结果列表
        LinkedList<Integer> ans = new LinkedList<>();

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(tree.get(0).get(0));
        // 层序遍历
        while (queue.size() > 0){
            Node node = queue.removeFirst();
            if (node != null){
                ans.add(node.val);
                queue.add(node.lc);
                queue.add(node.rc);
            }else {
                ans.add(null);
            }
        }

        while (true){
            // 最后的null子节点不用输出
            if (ans.getLast() == null){
                ans.removeLast();
            }else {
                break;
            }
        }

        StringJoiner sj = new StringJoiner(", ","[","]");
        for (Integer an : ans){
            sj.add(an + "");
        }

        return sj.toString();
    }
}
class Node{
    int val;
    Node lc;
    Node rc;
    public Node(int val){
        this.val = val;
        this.lc = null;
        this.rc = null;
    }
}
