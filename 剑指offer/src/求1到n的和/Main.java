package 求1到n的和;

public class Main {
	
	//利用逻辑与的短路特性实现递归终止
	public static int Sum_Solution(int n){
		int t =0;
		boolean b = (n>0) && (t = Sum_Solution(n-1)+n)>0;
		
		return t;
	}
	
	public static void main(String[] args) {
		System.out.println(Sum_Solution(5));
	}
}
