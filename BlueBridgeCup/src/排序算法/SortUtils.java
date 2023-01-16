package 排序算法;

public class SortUtils {
	/*
	 * 对数组,arr[left] (包含) 到arr[right](包含)的元素实施快速排序
	 */
	public static void quickSort(int[] arr, int left, int right){
		//如果left不小于right，需要排序的部分只有一个元素，方法返回
		if(left>=right){
			return;
		}
		//设置最左边的元素为基准点，pivot
		int p = arr[left];
		
		//把要排序的序列中比p大的放到右边，比p小的放到左边，p的下标位置为i
		int i = left, j = right;
		while(i<j){
			//j向左移，找到一个比p小的元素
			while(arr[j]>=p && i<j){
				j--;
			}
			//i向右移，找到一个比p大的元素
			while(arr[i]<=p && i<j){
				i++;
			}
			//i和j交换
			if(i<j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		arr[left] = arr[i];
		arr[i] = p;
		
		//对序列中，i左边的元素实施快速排序
		quickSort(arr, left, i-1);
		//对序列中，i右边的元素实施快速排序
		quickSort(arr, i+1, right);
		
	}
}
