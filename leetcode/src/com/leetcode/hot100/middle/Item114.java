package com.leetcode.hot100.middle;

public class Item114 {

    /**
     *
     *二叉树展开为链表
     *
     *给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *
     * 展开后的单链表应该同样使用 easy.TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     * */

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode prev = new TreeNode(-1);
    public void flatten(TreeNode root){
        traverse(root);
    }

    public void traverse(TreeNode treeNode){
        if (treeNode == null){
            return;
        }

        prev.left = null;
        prev.right = treeNode;
        prev = treeNode;

        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;

        traverse(left);
        traverse(right);

    }

}
