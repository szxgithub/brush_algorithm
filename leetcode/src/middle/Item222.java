package middle;

public class Item222 {

    /*
    完全二叉树的节点个数
     */

    /*
    递归  时间复杂度度O（n）
     */
    public int countNodes(TreeNode root){
        if (root == null){
            return 0;
        }
        return countNodes(root.right) + countNodes(root.left) + 1;
    }

    public int countNodes2(TreeNode root){

        TreeNode l = root, r = root;
        int lh = 0, rh = 0;
        while (l != null){
            l = l.left;
            lh++;
        }

        while (r != null){
            r = r.right;
            rh++;
        }

        if (lh == rh){
            return (int)Math.pow(2,lh) - 1;
        }

        return countNodes2(root.left) + countNodes2(root.right) + 1;

    }

    public static void main(String[] args) {



    }

}
