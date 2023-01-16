package 平衡二叉树;
/*
 * 平衡二叉树又称AVL树，且具有以下性质：
 * 它是一颗空树或者它的左右子树的高度差不超过1，并且左右两个子树都是一颗平衡二叉树
 */
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val){
		this.val = val;
	}
}
public class Main {
	public boolean IsBalanced_Solution(TreeNode root){
		if(root==null) return true;
		if(Math.abs(MaxDepth(root.left)-MaxDepth(root.right))>1){
			return false;
		}
		return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
	}
	
	public int MaxDepth(TreeNode root){
		if(root==null){
			return 0;
		}
		return 1+Math.max(MaxDepth(root.left), MaxDepth(root.right));
	}
	
	public TreeNode createBinaryTreeByArray(int[] array, int index){
		TreeNode tn = null;
		if(index<array.length){
			int value = array[index];
			tn = new TreeNode(value);
			tn.left = createBinaryTreeByArray(array,2*index+1);
			tn.right = createBinaryTreeByArray(array, 2 * index + 2);
			return tn;
		}
		return tn;
	}
}
