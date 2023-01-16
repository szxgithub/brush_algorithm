package 二叉搜索树与双向链表;

class TreeNode{
	int val =0;
	TreeNode left = null;
	TreeNode right = null;
	
	public TreeNode(int val){
		this.val = val;
	}
}
public class Main {
	
	TreeNode front =null;
	TreeNode rear = null;
	
	public TreeNode Convert(TreeNode pRootOfTree){
		if(pRootOfTree==null){
			return null;
		}
		Convert(pRootOfTree.left);
		if(rear==null){
			front = rear = pRootOfTree;
		}else{
			rear.right = pRootOfTree;
			pRootOfTree.left = rear;
			rear = pRootOfTree;
		}
		Convert(pRootOfTree.right);
		return front;
	}
}
