package �����㷨;

/*
 * ���Բ���https://blog.csdn.net/sunhuaqiang1/article/details/52059322
 * д�ĺܺ�
 */
import java.util.Arrays;

public class ��������2 {
	
	public static void main(String[] args) {
		int[] a = {3,1,2,5,4};
		quickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
	public static void quickSort(int[] a, int left, int right){
		int i,j,t,base;
		if(left>right){
			return;
		}
		
		base = a[left]; //��ŵ��ǻ�׼��
		
		i = left;	//���������ڱ�
		j = right;
		
		while(i!=j){
			
			//˳�����Ҫ��Ҫ���ұ߿�ʼ��(�ǳ���Ҫ��)
			while(a[j]>=base && i<j){
				j--;
			}
			while(a[i]<=base && i<j){
				i++;
			}
			//�����������������е�λ��
			if(i<j){
				t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		
		a[left]= a[i];
		a[i] = base;
		quickSort(a,left,i-1);
		quickSort(a,i+1,right);
		
	}
}
