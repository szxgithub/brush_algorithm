package com.leetcode.hot100.middle;

public class Item116 {

    /**
     *
     * 填充每个节点的下一个右侧节点指针
     *
     *
     * */


    class Node{
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(){

        }

        public Node(int _val){
            this.val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node next){

        }
    }

    public Node connect(Node root){
        if (root == null){
            return root;
        }
        traverse(root.left,root.right);
        return root;
    }

    public void traverse(Node node1, Node node2){
        if (node1 == null || node2 == null){
            return;
        }
        node1.next = node2;
        traverse(node1.left,node1.right);
        traverse(node2.left,node2.right);

        traverse(node1.right,node2.left);
    }

    public static void main(String[] args) {



    }

}
