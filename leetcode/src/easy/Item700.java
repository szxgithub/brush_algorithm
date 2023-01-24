package easy;

public class Item700 {

    /**
     *
     * 二叉搜索树中的搜索
     *
     * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val){
        if (root == null){
            return null;
        }

        if (root.val > val){
            return searchBST(root.left,val);
        }else if (root.val < val) {
            return searchBST(root.right,val);
        }else {
            return root;
        }
    }

}
