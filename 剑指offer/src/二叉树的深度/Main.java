package 二叉树的深度;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
	int val =0;
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode(int val){
		this.val = val;
	}
}
public class Main {
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9};
		TreeNode treeNode = createBinaryTreeByArray(array, 0);
		System.out.println(TreeDepth(treeNode));
		
	}
	
	//非递归，层次遍历
	public int TreeDepth_2(TreeNode root){
		if(root == null){
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int start  =0;
		int end = 1;
		int depth = 0;
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			start++;
			if(temp.left!=null){
				queue.offer(temp.left);
			}
			if(temp.right!=null){
				queue.offer(temp.right);
			}
			if(start==end){
				start=0;
				end = queue.size();
				depth++;
			}
		}
		return depth;
	}
	
	
	//递归求深度
	public static int TreeDepth(TreeNode root){
		if(root==null){
			return 0;
		}
		return 1+Math.max(TreeDepth(root.left), TreeDepth(root.right));
	}
	
	public static TreeNode createBinaryTreeByArray(int[] array, int index){
		TreeNode tn = null;
		if(index<array.length){
			int value = array[index];
			tn = new TreeNode(value);
			tn.left = createBinaryTreeByArray(array,2*index+1);
			tn.right = createBinaryTreeByArray(array,2*index+2);
			return tn;
		}
		return tn;
	}
}
