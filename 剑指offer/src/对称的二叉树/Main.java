package 对称的二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
	//递归方法实现
	boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null)
        	return true;
        if(pRoot.left==null && pRoot.right==null){
        	return true;
        }
        if(pRoot.left==null || pRoot.right==null){
        	return false;
        }
        return isSymmetrical(pRoot.left,pRoot.right);
    }
	
	public static boolean isSymmetrical(TreeNode root1,TreeNode root2){
		if(root1==null && root2==null){
			return true;
		}
		if(root1==null || root2==null){
			return false;
		}
		if(!(root1.val==root2.val)){
			return false;
		}
		return isSymmetrical(root1.left,root2.right) && isSymmetrical(root1.right, root2.left);
	}
	
	//迭代实现
	public static boolean isSymmetrical1(TreeNode root){
		if(root == null){
			return true;
		}
		if(root.left==null && root.right==null){
			return true;
		}
		if(root.left==null || root.right==null){
			return false;
		}
		
		Queue<TreeNode> queueleft = new LinkedList<>();
		Queue<TreeNode> queueright = new LinkedList<>();
		
		queueleft.offer(root.left);
		queueright.offer(root.right);
		
		TreeNode templeft,tempright;
		while(!queueleft.isEmpty() || !queueright.isEmpty()){
			templeft = queueleft.poll();
			tempright = queueright.poll();
			if(templeft.val==tempright.val){
				if(templeft.left!=null)
					queueleft.offer(templeft.left);
				if(templeft.right!=null){
					queueleft.offer(templeft.right);
				}
				if(tempright.left!=null){
					queueright.offer(tempright.right);
				}
				if(tempright.left!=null){
					queueright.offer(tempright.left);
				}
			}else{
				return false;
			}
		}
		if(queueleft.isEmpty() && queueright.isEmpty()){
			return true;
		}else{
			return false;
		}
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