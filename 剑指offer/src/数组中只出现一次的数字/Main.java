package 数组中只出现一次的数字;

import java.util.HashSet;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		int[] test= {1,1,1,1,4,6};
		int[] num1 = {0};
		int[] num2 = {0};
		FindNumsAppearOnce(test, num1, num2);
		System.out.println(num1[0]+" "+num2[0]);
	}
	
	//szx  写的
	//num1,num2分别为长度为1的数组。传出参数
	//将num1[0],num2[0]设置为返回结果
	public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]){
		boolean flag = false;
		String jihe = "";
		for(int i=0;i<array.length;i++){
			int j =0;
			for(j=i+1;j<array.length;j++){
				if(array[i]==array[j]){
					jihe+=array[i];
					break;
				}
			}
			if(j>=array.length){
				if(flag==false){
					if(!jihe.contains(array[i]+"")){					
						num1[0] = array[i];
						flag = true;
					}
				}
				if(!jihe.contains(array[i]+"")){					
					num2[0] = array[i];
				}
			}
		}
	}
	
	
	public static void FindNumsAppearOnce2(int[] array, int num1[], int num2[]){
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<array.length;i++){
			if(!set.add(array[i])){
				set.remove(array[i]);
			}
		}
		Iterator<Integer> iterator = set.iterator();
		num1[0] = iterator.next();
		num2[0] = iterator.next();
	}
}
