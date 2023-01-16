package 经典递归问题2;
/*
 * 计算杨辉三角第m层第n个系数的计算方法(m,n都是从0算起的)
 * 
 */
public class B {
	
	public static void main(String[] args) {
		
	}
	
	public static int f(int m, int n){
		if(m==0) return 1;
		if(n==0 || n==m) return 1;
		return f(m-1,n-1) + f(m-1,n);
	}
}
