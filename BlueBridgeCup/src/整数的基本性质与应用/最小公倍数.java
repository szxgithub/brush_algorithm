package �����Ļ���������Ӧ��;

public class ��С������ {
	public static void main(String[] args) {
		//��С������ = a*b / gcd(a,b)
		
	}
	
	//a �� n����
	//a ��n���ݶ�pȡģ
	public static int f(int a, int n, int p){
		int x = 1;
		for(int i=0;i<n;i++)
			x = x*a%p;
		return x; 
	}
}
