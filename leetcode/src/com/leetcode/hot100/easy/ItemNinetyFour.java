package com.leetcode.hot100.easy;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *

 二叉树的中序遍历

 */
class TreeNode{

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){

    }

    TreeNode(int val){
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
public class ItemNinetyFour {



        public List<Integer> inorderTravelsal(TreeNode root){
            List<Integer>  list = new ArrayList<>();
            inorder(root,list);
            return list;
        }

        //递归算法 二叉树中序遍历
        public void inorder(TreeNode root, List<Integer> res){
            if(root == null){
                return;
            }
            inorder(root.left,res);
            res.add(root.val);
            inorder(root.right,res);
        }

    //使用一个栈， 相比递归是显示的算法
    public List<Integer> inorderTravelsal2(TreeNode root){
        List<Integer>  list = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();

        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }



}
