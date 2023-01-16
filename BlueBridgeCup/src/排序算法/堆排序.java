package 排序算法;
import java.util.Arrays;

public class 堆排序 {
	public static void main(String[] args) {
		int[] arr = {9,8,7,6,5,4,3,2,1};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr){
		//1,构建大顶堆
		for(int i=arr.length/2-1;i>=0;i--){
			//从第一个非叶子结点从下至上，从右至左调整结构
			adjustHeap(arr,i,arr.length);
		}
	}
	
	public static void adjustHeap(int[] arr, int i, int length){
		int temp = arr[i];	//先取出当前元素i
		for(int k=i*2+1;k<length;k=k*2+1){	//从i结点的左子结点开始，也就是2i+1处开始
			if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
				k++;
			}
			if(arr[k]>temp){
				arr[i]=arr[k];
				i=k;
			}else{
				break;
			}
		}
		arr[i] = temp;	//将temp值放到最终的位置
	}
	
	 /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
