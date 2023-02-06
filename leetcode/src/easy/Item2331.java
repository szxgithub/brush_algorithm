package easy;

public class Item2331 {

    /*

    计算布尔二叉树的值


     */

    public boolean evaluateTree(TreeNode root){

        if (root.val == 0){
            return false;
        }else if (root.val == 1){
            return true;
        }

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if (root.val == 2){
            return left || right;
        }

        if (root.val == 3){
            return left && right;
        }else {
            return false;
        }

    }

}
