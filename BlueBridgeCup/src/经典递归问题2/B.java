package ����ݹ�����2;
/*
 * ����������ǵ�m���n��ϵ���ļ��㷽��(m,n���Ǵ�0�����)
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
