package 递归与循环;

public class B {
	//求数组a中，从begin到结束的元素和
	public static int f(int[] a, int begin){
		if(begin == a.length) return 0;
		int x = f(a,begin+1);
		return x + a[begin];
	}
}
