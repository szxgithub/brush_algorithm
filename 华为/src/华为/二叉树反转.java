package 华为;

import java.util.LinkedList;

public class 二叉树反转 {
    //非递归
    public void noRecursive(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            TreeNode tmpLeft = tmp.left;
            tmp.left = tmp.right;
            tmp.right = tmpLeft;
            if(tmp.left!=null){
                stack.push(tmp.left);
            }
            if(tmp.right!=null){
                stack.push(tmp.right);
            }
        }
    }

    //递归
    public void recursive(TreeNode root){
        if(root!=null){
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            recursive(root.left);
            recursive(root.right);
        }
    }

}

class TreeNode{
    int val =0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val){
        this.val = val;
    }
}
