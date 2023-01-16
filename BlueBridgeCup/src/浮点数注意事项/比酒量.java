package 浮点数注意事项;

public class 比酒量 {
	
	//暴力破解
	public static void main(String[] args) {
		for(int a=20;a>=0;a--){
			for(int b=a-1;b>=0;b--){
				for(int c=b-1;c>=0;c--){
					for(int d=c-1;d>=0;d--){
						if((b*c*d + a*c*d + a*b*d + a*b*c)==a*b*c*d){
							System.out.println(a+","+b+","+c+","+d);
						}
					}
				}
			}
		}
	}
	
	
}
