package 斐波那契数列;

import java.util.Scanner;

public class Main {
	public int Fibonacci(int n) {
		if(n==0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		return Fibonacci(n-1)+Fibonacci(n-2);
    }
	
	public static void main(String[] args) {
		Main m = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = m.Fibonacci(n);
		System.out.println(res);
	}
}
