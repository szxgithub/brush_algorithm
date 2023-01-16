package 经典递归问题2;
/*
 * 计算3个A， 2个B可以组成多少种排列的问题
 * 如：AAABB   AABBA
 */
//计算m个A， n个B可以组合成多少个不同排列的问题
public class C {
	public static void main(String[] args) {
		System.out.println(f(3,2));
	}
	
	public static int f(int m, int n){
		if(m==0 || n==0)
			return 1;
		return f(m-1,n)+f(m,n-1);
	}
}
