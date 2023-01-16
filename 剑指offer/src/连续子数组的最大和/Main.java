package 连续子数组的最大和;

public class Main {
	
	public static void main(String[] args) {
		int[] array = {6,-3,-2,7,-15,1,2,2};
		int res = FindGreatestSumOfSubArray(array);
		System.out.println(res);
	}
	
	/*
	  	动态规划算法解决
	  public int FindGreatestSumOfSubArray(int[] array){
		if(array.length==0)
			return 0;
		int sum = array[0];		//保存每组的和
		int maxSum = array[0];	//连续子数组最大和
		
		//动态规划
		for(int i=1;i<array.length;i++){
			sum = Math.max(sum+array[i], array[i]);
			maxSum = Math.max(sum, maxSum);
		}
		return maxSum;
	}*/
	
	//暴力解决
	/*public static int FindGreatestSumOfSubArray(int[] array){
		if(array==null || array.length<=0)	return 0;
		int maxSumOfSubArray = Integer.MIN_VALUE;
		for(int i=0;i<array.length;i++){
			int sum = array[i];
			if(sum>maxSumOfSubArray){
				maxSumOfSubArray = sum;
			}
			for(int j=i+1;j<array.length;j++){
				if(sum + array[j] > maxSumOfSubArray){
					maxSumOfSubArray = sum + array[j];
				}
				sum = sum + array[j];
			}
		}
		return maxSumOfSubArray;
	}
	*/
	
	
	public static int FindGreatestSumOfSubArray(int[] array){
		if(array==null || array.length<=0){
			return 0;
		}
		int sum = array[0];
		int maxSumOfSubArray = sum;
		for(int i=1;i<array.length;i++){
			if(sum>=0){
				sum = sum+array[i];
			}else{
				sum = array[i];
			}
			if(sum>=maxSumOfSubArray){
				maxSumOfSubArray = sum;
			}
		}
		return maxSumOfSubArray;
	}
	
}
