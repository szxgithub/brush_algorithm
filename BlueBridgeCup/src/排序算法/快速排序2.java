package 排序算法;

/*
 * 来自博客https://blog.csdn.net/sunhuaqiang1/article/details/52059322
 * 写的很好
 */
import java.util.Arrays;

public class 快速排序2 {
	
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
		
		base = a[left]; //存放的是基准数
		
		i = left;	//设置两个哨兵
		j = right;
		
		while(i!=j){
			
			//顺序很重要，要从右边开始找(非常重要！)
			while(a[j]>=base && i<j){
				j--;
			}
			while(a[i]<=base && i<j){
				i++;
			}
			//交换两个数在数组中的位置
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
