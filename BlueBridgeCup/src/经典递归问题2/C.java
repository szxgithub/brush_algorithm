package ����ݹ�����2;
/*
 * ����3��A�� 2��B������ɶ��������е�����
 * �磺AAABB   AABBA
 */
//����m��A�� n��B������ϳɶ��ٸ���ͬ���е�����
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
