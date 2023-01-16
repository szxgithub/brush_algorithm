import java.math.BigInteger;
import java.util.Scanner;

public class Niu {
	
	static int n;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(BigInteger i =BigInteger.valueOf(n);;i=i.add(BigInteger.ONE)){
			int j=0;
			for(j=2;j<=n;j++){
				BigInteger[] temp = i.divideAndRemainder(BigInteger.valueOf(j));
				if(temp[1].equals(BigInteger.ZERO)){
					continue;
				}else{
					break;
				}
			}
			if(j>n){
				System.out.println(i.mod(BigInteger.valueOf(987654321)));
				break;
			}
		}
		
	}
}
