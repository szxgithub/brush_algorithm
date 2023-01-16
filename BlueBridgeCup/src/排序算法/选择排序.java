package 排序算法;

public class 选择排序 {
	public static int[] selectionSort(int[] array){
		if(array.length==0)
			return array;
		for(int i=0;i<array.length;i++){
			int minIndex = i;
			for(int j=i;j<array.length;j++){
				if(array[j]<array[minIndex]) //找到最小的数
					minIndex = j;	//将最小的数的索引保存
			}
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
		return array;
	}
}
