package 二叉搜索树的第K个结点;

import java.util.Stack;

public class Main {
	
	
	public  TreeNode kthNode(TreeNode pRoot,int k){
        //栈顶元素保证一直是cur的父节点
        if(pRoot==null || k<0)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRoot;
        int count = 0;
        while (!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pop();
                count++;
                if(count==k)
                    return cur;
                cur = cur.right;
            }
        }
        return null;
    }
	
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

