package 和为S的两个数字;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		int[] number = {1,2,4,7,11,15};
		ArrayList<Integer> list =FindNumberWithSum(number, 15);
		System.out.println(list);
	}
	
	public static ArrayList<Integer> FindNumberWithSum(int[] array, int sum){
		
		ArrayList<Integer> list = new ArrayList<>();
		int tmp =0;
		for(int i=0;i<array.length;i++){
			tmp+=array[i];
			for(int j=i+1;j<array.length;j++){
				tmp+=array[j];
				if(tmp==sum){
					list.add(array[i]);
					list.add(array[j]);
					return list;
				}
				tmp-=array[j];
			}
			tmp=0;
		}
		
		return list;
	}
}
