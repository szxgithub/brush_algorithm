package 数字在排序数组中出现的次数;

public class Main {
	public static void main(String[] args) {
		
	}
	
	//顺序查找
	public int GetNumberOfK(int[] array, int k){
		int count=0;;
		for(int i=0;i<array.length;i++){
			if(array[i]==k){
				count++;
			}
		}
		return count;
	}
	
	//二分查找(应该用这种)
	/*public int GetNumberOfK2(int[] array, int k){
		
	}*/
}
