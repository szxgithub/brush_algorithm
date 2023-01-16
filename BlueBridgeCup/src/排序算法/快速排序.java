package 排序算法;
/*
 * 通过一趟排序将待排序记录分隔成独立的两部分，其中一部分记录的关键字均比另一个部分的关键字小
 * 则可分别对这两部分记录继续进行排序
 */
public class 快速排序 {
	public static int[] QuickSort(int[] array, int start, int end){
		if(array.length<1||start<0||end>=array.length||start>end)
			return null;
		int smallIndex = partition(array,start,end);
		if(smallIndex > start)
			QuickSort(array, start, smallIndex-1);
		if(smallIndex<end)
			QuickSort(array,smallIndex+1, end);
		return array;
	}
	
	public static int partition(int[] array,int start,int end){
		int pivot = (int)(start+Math.random()*(end-start+1));
		int smallIndex = start-1;
		swap(array, pivot, end);
	       for (int i = start; i <= end; i++)
	           if (array[i] <= array[end]) {
	               smallIndex++;
	               if (i > smallIndex)
	                   swap(array, i, smallIndex);
	           }
	       return smallIndex;
	}
	
	public static void swap(int[] array, int i, int j) {
	       int temp = array[i];
	       array[i] = array[j];
	       array[j] = temp;
	   }
}
