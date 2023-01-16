package 数值的整数次方;

public class Main {
	public double Power(double base, int exponent) {
		if(exponent==0){
			return 1;
		}else if(exponent>0){
			double num = base;
			for(int i=1;i<exponent;i++){
				num = num*base;
			}
			return num;
		}else{
			double nums = base;
			int flag = -exponent;
			for(int i=1;i<flag;i++){
				nums = nums*base;
			}
			return 1/nums;
		}
		
	}
	
	/*public double Power(double base, int exponent) {
		return Math.pow(base, exponent);
	}*/
}
