package 数组中重复的数字;

public class Main {
	// Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
    	if(length<=0 || numbers==null){
    		return false;
    	}
    	//判断数组数据是否合法
    	for(int i=0;i<length;i++){
    		if(numbers[i]<0 || numbers[i]>length-1){
    			return false;
    		}
    	}
    	
    	for(int i=0;i<length;i++){
    		while(numbers[i]!=i){
    			if(numbers[i]!=numbers[numbers[i]]){
    				duplication[0] = numbers[i];
    				return true;
    			}else{
    				int temp = numbers[i];
    				numbers[i] = numbers[temp];
    				numbers[temp] = temp;
    			}
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args) {
        int[] arr ={2,3,1,0,2,5,3};
        int[] duplication = {-1};
        duplicate(arr,arr.length,duplication);
        System.out.println(duplication[0]);
    }
}
