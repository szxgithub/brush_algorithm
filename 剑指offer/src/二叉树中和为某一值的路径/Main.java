package 二叉树中和为某一值的路径;

import java.util.ArrayList;

public class Main {
	private ArrayList<ArrayList<Integer>> listAll = new ArrayList();
	private ArrayList<Integer> list = new ArrayList();
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {  
       if(root ==null){
    	   return listAll;
       }
       list.add(root.val);
       target-=root.val;
       if(target==0 && root.left==null && root.right==null){
    	   listAll.add(new ArrayList<Integer>(list));
       }
       FindPath(root.left, target);
       FindPath(root.right, target);
       list.remove(list.size()-1);
       return listAll;
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

