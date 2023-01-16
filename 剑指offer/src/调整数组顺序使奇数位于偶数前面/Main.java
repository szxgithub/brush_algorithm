package 调整数组顺序使奇数位于偶数前面;

public class Main {
	public void reOrderArray(int [] array) {
		
        if(array.length==0||array.length==1)
        				return;
        int oddCount =0, oddBegin = 0;
        int[] newArray = new int[array.length];
        for(int i=0;i<array.length;i++){
        	if((array[i]&1)==1) oddCount++;
        }
        
        for(int i=0;i<array.length;i++){
        	if((array[i]&1)==1)
        		newArray[oddBegin++] = array[i];
        	else
        		newArray[oddCount++] = array[i];
        }
        
        for(int i=0;i<array.length;i++){
        	array[i] = newArray[i];
        }


    }
}
