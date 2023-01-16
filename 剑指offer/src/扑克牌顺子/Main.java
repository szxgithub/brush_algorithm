package 扑克牌顺子;

import java.util.Arrays;

public class Main {
	public boolean isContinue(int[] numbers){
		if(numbers.length<5){
			return false;
		}
		Arrays.sort(numbers);
		int cnt =0;
		for(int num:numbers){
			if(num==0){
				cnt++;
			}
		}
		
		for(int i=cnt;i<numbers.length-1;i++){
			if(numbers[i+1]==numbers[i])
				return false;
			int interval = numbers[i+1] - numbers[i] -1;	//相邻数字间隔
			if(interval > cnt){
				return false;
			}
			cnt-=interval;	//用王来补间隔
		}
		return true;
	}
}
