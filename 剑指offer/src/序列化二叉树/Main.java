package 序列化二叉树;

public class Main {
	String Serialize(TreeNode root) {
			if(root==null){
				return "$,";
			}
			StringBuilder result = new StringBuilder();
			result.append(root.val);
			result.append(",");
			
			result.append(Serialize(root.left));
			result.append(Serialize(root.right));
			return result.toString();
	  }
	
	  TreeNode Deserialize(String str) {
	       StringBuilder stringBuilder = new StringBuilder(str);
	       return deserializeCore(stringBuilder);
	  }
	  
	  public TreeNode deserializeCore(StringBuilder stringBuilder){
		  if(stringBuilder.length()==0)
	            return null;
	        String num = stringBuilder.substring(0,stringBuilder.indexOf(","));
	        stringBuilder.delete(0,stringBuilder.indexOf(","));
	        stringBuilder.deleteCharAt(0);
	        if(num.equals("$"))
	            return null;
	        TreeNode node = new TreeNode(Integer.parseInt(num));
	        node.left = deserializeCore(stringBuilder);
	        node.right = deserializeCore(stringBuilder);
	        return node;
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