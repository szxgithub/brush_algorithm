package 按之字形顺序打印二叉树;

import java.util.ArrayList;
import java.util.Stack;


public class Main {
	public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		if(pRoot==null){
			return lists;
		}
		
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		TreeNode tmp = null;
		stack1.push(pRoot);
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			if(!stack1.isEmpty()){
				ArrayList<Integer> list = new ArrayList<>();
				while(!stack1.isEmpty()){
					tmp = stack1.pop();
					list.add(tmp.val);
					if(tmp.left!=null)
						stack2.push(tmp.left);
					if(tmp.right!=null)
						stack2.push(tmp.right);
				}
				lists.add(list);
			}else{
				ArrayList<Integer> list = new ArrayList<>();
				while(!stack2.isEmpty()){
					tmp = stack2.pop();
					list.add(tmp.val);
					if(tmp.right!=null)
						stack1.push(tmp.right);
					if(tmp.left!=null)
						stack1.push(tmp.left);
				}
				lists.add(list);
			}
		}
		return lists;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        ArrayList<ArrayList<Integer>> lists = Print(root);
        System.out.println(lists);
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