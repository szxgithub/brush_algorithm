package 不用加减乘除做加法;

public class Main {
	
	public static void main(String[] args) {
		
	}
	
	public int Add(int num1, int num2){
		/*if(num1<0){
			while(num1++ != 0){
				num2--;
			}
		}else if(num1 > 0){
			while(num1-- !=0){
				num2++;
			}
		}
		return num2;*/
		
		//return Integer.sum(num1, num2);
		
		if(num2==0)
			return num1;
		return Add(num1^num2, (num1&num2)<<1);
		
	}
	
	
}
