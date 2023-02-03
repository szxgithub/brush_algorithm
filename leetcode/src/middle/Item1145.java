package middle;

public class Item1145 {

    /*
    二叉树着色游戏

     */

    private int left;
    private int right;
    private int num;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        num = x;
        dfs(root);
        int half = n / 2;
        if (left > half || right > half || (left + right) < half) {
            return true;
        } else {
            return false;
        }
    }

    private int dfs(TreeNode node) {
        int leftNum = 0;
        int rightNum = 0;
        if (node.left != null) {
            leftNum = dfs(node.left);
        }
        if (node.right != null) {
            rightNum = dfs(node.right);
        }
        if (node.val == num) {
            left = leftNum;
            right = rightNum;
        }
        return leftNum + rightNum + 1;
    }

}
