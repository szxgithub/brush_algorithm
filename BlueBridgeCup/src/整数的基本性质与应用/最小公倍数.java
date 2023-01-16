package 整数的基本性质与应用;

public class 最小公倍数 {
	public static void main(String[] args) {
		//最小公倍数 = a*b / gcd(a,b)
		
	}
	
	//a 的 n次幂
	//a 的n次幂对p取模
	public static int f(int a, int n, int p){
		int x = 1;
		for(int i=0;i<n;i++)
			x = x*a%p;
		return x; 
	}
}
