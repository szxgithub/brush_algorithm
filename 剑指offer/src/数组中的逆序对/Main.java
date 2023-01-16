package 数组中的逆序对;

public class Main {
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,0};
		int tmp = InversePairs(a);
		System.out.println(tmp);
	}
	
	//暴力破解，复杂度太高
	public static int InversePairs(int[] array){
		int count =0;
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[i]>array[j]){
					count++;
				}
			}
		}
		return count%1000000007;
	}
	
	//归并排序方法
	public static int mergeCount(int[] array, int[] copy, int start, int end){
		if(start==end){
			copy[start] = array[start];
			return 0;
		}
		
		int mid = (start+end)>>1;
		
		int leftCount = mergeCount(copy,array,start,mid);
		int rightCount = mergeCount(copy, array, mid+1, end);
		
		int i = mid;//i初始化为前半段最后一个数字的下标
        int j = end;//j初始化为后半段最后一个数字的下标
		
        int index = end;//辅助数组复制的数组的最后一个数字的下标
        int count = 0;//计数--逆序对的数目
        
        while(i>=start && j>=mid+1){
        	if(array[i]>array[j]){
        		copy[index--] = array[i--];
        		count+=j-mid;
        	}else{
        		copy[index--]=array[j--];
        	}
        }
        for(;i>=start;i--){
        	copy[index--] = array[i];
        }
        for(;j>=mid+1;j--){
        	copy[index--] = array[j];
        }
        return leftCount + rightCount + count;
	}
}
