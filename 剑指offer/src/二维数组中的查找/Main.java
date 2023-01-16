package 二维数组中的查找;

public class Main {
	
	/**
	 * 每一行都按照从左到右递增的顺序排序，每一行看作有序递增的数组
	 * @param target
	 * @param array
	 * @return
	 */
	public boolean Find(int target, int[][] array){
		if(array==null || array.length==0 || (array.length==1 && array[0].length==0))
			return false;
		for(int i=0;i<array.length;i++){
			int begin =0;
			int end = array[0].length-1;
			while(begin<=end){
				int mid = (begin+end)/2;
				if(target>array[i][mid]){
					begin = mid+1;
				}else if(target<array[i][mid]){
					end = mid - 1;
				}else{
					return true;
				}
			}
		}
		return false;
	}
}
