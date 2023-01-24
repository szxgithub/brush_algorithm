package middle;

public class Item450 {

    /**
     *
     *删除二叉搜索树中的节点
     *
     *给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
     * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     *
     * 一般来说，删除节点可分为两个步骤：
     *
     * 首先找到需要删除的节点；
     * 如果找到了，删除它。
     *
     *
     * */
    public TreeNode deleteNode(TreeNode root, int val){
        if (root == null){
            return null;
        }

        if (root.val > val){
            root.left = deleteNode(root.left,val);
        }else if (root.val < val){
            root.right =  deleteNode(root.right,val);
        }else if (root.val == val){
            // 找到了，进行删除
            if (root.left == null && root.right == null){
                return null;
            }
            if (root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }

            // 查找当前节点右子树中最小的节点
            TreeNode p = getMinTreeNode(root.right);
            root.right = deleteNode(root.right,p.val);
            p.left = root.left;
            p.right = root.right;
            root = p;
        }

        return root;
    }

    private TreeNode getMinTreeNode(TreeNode root) {
        while (root.left != null){
            root = root.left;
        }
        return root;
    }

}
