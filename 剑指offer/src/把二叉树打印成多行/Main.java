package 把二叉树打印成多行;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Main {
	static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		
		ArrayList<ArrayList<Integer> > lists = new ArrayList<ArrayList<Integer> >();
		
		if(pRoot == null){
			return lists ;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(pRoot);
		TreeNode temp = null;
		
		
		while(!queue.isEmpty()){
			ArrayList<Integer> list = new ArrayList<>();
			for(int size = queue.size();size>0;size--){
				temp = queue.poll();
				list.add(temp.val);
				
				if(temp.left!=null){
					queue.offer(temp.left);
				}
				if(temp.right!=null){
					queue.offer(temp.right);
				}
			}
			lists.add(list);
		}
		return lists;
    }
	
	public static void main(String[] args){
        //            1
        //          /   \
        //         2     3
        //       /  \   / \
        //      4    5 6   7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        ArrayList<ArrayList<Integer> > lists = Print(root);
        System.out.println(lists);
    }
	
}
