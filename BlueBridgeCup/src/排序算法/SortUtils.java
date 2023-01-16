package �����㷨;

public class SortUtils {
	/*
	 * ������,arr[left] (����) ��arr[right](����)��Ԫ��ʵʩ��������
	 */
	public static void quickSort(int[] arr, int left, int right){
		//���left��С��right����Ҫ����Ĳ���ֻ��һ��Ԫ�أ���������
		if(left>=right){
			return;
		}
		//��������ߵ�Ԫ��Ϊ��׼�㣬pivot
		int p = arr[left];
		
		//��Ҫ����������б�p��ķŵ��ұߣ���pС�ķŵ���ߣ�p���±�λ��Ϊi
		int i = left, j = right;
		while(i<j){
			//j�����ƣ��ҵ�һ����pС��Ԫ��
			while(arr[j]>=p && i<j){
				j--;
			}
			//i�����ƣ��ҵ�һ����p���Ԫ��
			while(arr[i]<=p && i<j){
				i++;
			}
			//i��j����
			if(i<j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		arr[left] = arr[i];
		arr[i] = p;
		
		//�������У�i��ߵ�Ԫ��ʵʩ��������
		quickSort(arr, left, i-1);
		//�������У�i�ұߵ�Ԫ��ʵʩ��������
		quickSort(arr, i+1, right);
		
	}
}
