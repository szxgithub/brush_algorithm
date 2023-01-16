package 排序算法;

import java.util.Arrays;

/*
 * 希尔排序是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本
 * 也称为缩小增量排序，同时该算法是冲破O(n2）的第一批算法之一。
 * 
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序：随着增量的逐渐减少，每组包含的关键词雨来越多，
 * 当增量减至1时，整个文件恰被分成一组，算法终止
 */
public class 希尔排序 {
	
	public static void main(String[] args) {
		int[] arr1 = {56,18,6,3,97,66,8,26,88,30,99,93};
		String st = Arrays.toString(ShellSort(arr1));
		System.out.println(st);
	}
	
	public static int[] ShellSort(int[] array){
		int len = array.length;
		int temp, gap = len/2;
		
		while(gap>0){
			for(int i=gap;i<len;i++){
				temp = array[i];
				int preIndex = i-gap;
				while(preIndex>=0 && array[preIndex]>temp){
					array[preIndex+gap] = array[preIndex];
					preIndex -= gap;
				}
				array[preIndex+gap] = temp;
			}
			gap/= 2;
		}
		
		return array;
	}
}
