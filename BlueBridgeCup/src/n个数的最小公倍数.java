import java.math.BigInteger;
import java.util.Scanner;

public class n个数的最小公倍数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		f(n);
	}
	
	static void f(int n){
		int[] x = new int[n+1];
		for(int i=1;i<=n;i++){
			x[i] = i;
		}
		for(int i=2;i<n;i++){
			for(int j=i+1;j<=n;j++){
				if(x[j]%x[i]==0){
					x[j] = x[j]/x[i];
				}
			}
		}
		BigInteger m = BigInteger.ONE;
		for(int i=2;i<=n;i++){
			m = m.multiply(BigInteger.valueOf(x[i]));
		}
		System.out.println(m.mod(BigInteger.valueOf(987654321)));
	}
}
