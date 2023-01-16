package 滑动窗口的最大值;

import java.util.ArrayList;
//暴力解决的
public class Main {
	public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
        for(int i=0;i<num.length;i++){
        	
        	if(size==0){
        		break;
        	}
        	
        	int max =0;
        	
        	if((size+i)>num.length){
        		break;
        	}
        	
        	for(int j=i;j<size+i;j++){
        		if(num[j]>max){
        			max = num[j];
        		}
        	}
        	list.add(max);
        }
        
        return list;
    }
	
	public static void main(String[] args) {
		//int[] num = {2,3,4,2,6,2,5,1};
		int[] num = {10,14,12,11};
		
		ArrayList<Integer> res = new Main().maxInWindows(num, 0);
		System.out.println(res);
	}
}
