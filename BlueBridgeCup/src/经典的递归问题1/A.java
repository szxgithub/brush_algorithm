package ����ĵݹ�����1;
//��n�����У�����ȡ��m�������Żأ������ж����ֲ�ͬ��ȡ��
public class A {
	public static void main(String[] args) {
		int k = f(10,3);
		System.out.println(k);
	}
	
	public static int f(int n,int m){
		if(n<m)
			return 0;
		if(n==m)
			return 1;
		if(m==0)
			return 1;
		return f(n-1,m) + f(n-1,m-1); //n�������и�������x, ȡ������: ��������x
	}
}
