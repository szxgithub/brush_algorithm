package 从上往下打印二叉树;

import java.util.ArrayList;


public class Main {
	
	public static void main(String[] args) {
		
		
	}
	
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<TreeNode> queue = new ArrayList<>();
		
		if(root==null)
			return list;
		
		queue.add(root);
		
		while(queue.size()!=0){
			TreeNode temp = queue.remove(0);
			if(temp.left!=null){
				queue.add(temp.left);
			}
			if(temp.right!=null){
				queue.add(temp.right);
			}
			list.add(temp.val);
		}
		return list;
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
