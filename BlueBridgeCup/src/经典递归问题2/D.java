package 经典递归问题2;

/*
 * 
 * 对n进行加法划分
 * a 缓冲， k:当前的位置
 */
public class D {
	public static void main(String[] args) {
		int[] a = new int[1000];
		f(6,a,0);
	}
	
	public static void f(int n, int[] a, int k){
		if(n<=0){
			for(int i=0;i<k;i++){
				System.out.print(a[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=n;i>0;i--){
			if(k>0 && i>a[k-1]) continue;
			a[k] = i;
			f(n-i, a, k+1);
		}
	}
}
