package 二叉搜索树的后序遍历;

public class Main {
	public static void main(String[] args) {
		
	}
	
	public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length==0){
        	return false;
        }
        
        boolean flag = this.isBST(sequence, 0, sequence.length-1);
        
        return flag;
    }
	
	public boolean isBST(int[] arr,int start,int end){
		if(start>=end){
			return true;
		}
		//当前数组的根节点
		int curElement = arr[end];
		
		int splitIndex;
		
		for(splitIndex = start;splitIndex<end && arr[splitIndex]<curElement;splitIndex++);
		
		for(int i=splitIndex;i<end;i++){
			if(arr[i]<curElement){
				return false;
			}
		}
		
		return isBST(arr,start,splitIndex-1) && isBST(arr,splitIndex,end-1);
	}
}
