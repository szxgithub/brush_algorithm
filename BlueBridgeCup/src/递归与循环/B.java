package �ݹ���ѭ��;

public class B {
	//������a�У���begin��������Ԫ�غ�
	public static int f(int[] a, int begin){
		if(begin == a.length) return 0;
		int x = f(a,begin+1);
		return x + a[begin];
	}
}
