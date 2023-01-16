package 数组中出现次数超过一半的数字;

import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) {
		int[] array = {1,2,3,2,2,2,5,4,2};
		int res = MoreThanHalfNum_Solution(array);
		System.out.println(res);
	}
	
	public static int MoreThanHalfNum_Solution(int[] array){
		int len  = array.length/2;
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int i=0;i<array.length;i++){
			if(hm.containsKey(array[i])){
				hm.put(array[i], hm.get(array[i])+1);				
			}else{
				hm.put(array[i], 1);
			}
		}
		
		for(Integer key : hm.keySet()){
			int tmp = hm.get(key);
			if(tmp>len){
				return key;
			}
		}
		return 0;
	}
}
