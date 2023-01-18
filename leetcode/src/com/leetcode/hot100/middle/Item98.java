package com.leetcode.hot100.middle;

public class Item98 {

    /**
     *
     * 验证二叉搜索树
     *
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     *
     * */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);
    }

    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max){
        if (root == null){
            return true;
        }
        if (min != null && min.val >= root.val){
            return false;
        }
        if (max != null && max.val <= root.val){
            return false;
        }
        return isValidBST(root.left,min,root) && isValidBST(root.right,root,max);
    }

    public static void main(String[] args) {

        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode5.left = treeNode4;
        treeNode5.right = treeNode6;

        treeNode4.left = treeNode3;
        treeNode4.right = treeNode7;

        Item98 item98 = new Item98();
        boolean validBST = item98.isValidBST(treeNode5);
        System.out.println(validBST);

    }

}
