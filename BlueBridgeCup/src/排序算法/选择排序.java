package �����㷨;

public class ѡ������ {
	public static int[] selectionSort(int[] array){
		if(array.length==0)
			return array;
		for(int i=0;i<array.length;i++){
			int minIndex = i;
			for(int j=i;j<array.length;j++){
				if(array[j]<array[minIndex]) //�ҵ���С����
					minIndex = j;	//����С��������������
			}
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
		return array;
	}
}
