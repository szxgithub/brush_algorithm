package �����㷨;
import java.util.Arrays;
/*
 * ��������ʱ�临�Ӷȸ�����������йأ�
 * ���ʱ�临�Ӷȿ��������£���Ȼ��O(n^2)
 */
public class �������� {
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
