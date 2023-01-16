package 排序算法;
import java.util.Arrays;
/*
 * 插入排序时间复杂度跟输入的数据有关，
 * 因此时间复杂度考虑最坏情况下，仍然是O(n^2)
 */
public class 插入排序 {
	public static void insertsort(int[] arr){
		
		for(int i=1;i<arr.length;i++){
			int j = i-1;
			int temp = arr[i];
			while(j>=0 && arr[j]>temp){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
		
		/*for(int i=1;i<arr.length;i++){
			int j = i;
			while(j>0&&arr[j]<arr[j-1]){
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				j--;
			}
		}*/
	}
	
	public static void main(String[] args) {
		int[] a = {5454,5645,2323,6573423,3,667,23,63,788,78,323};
		insertsort(a);
		System.out.println(Arrays.toString(a));;
	}
}
