package �����Ļ���������Ӧ��;

public class ���Լ�� {
	public static void main(String[] args) {
		
		/*int a = 15;
		int b = 40;
		
		//��a��b�����Լ��
		for(int i=a;i>=1;i--){
			if(a%i==0 && b%i==0){
				System.out.println(i);
				break;
			}
		}*/
		
		//[a ,b] -- [b%a,a] [15, 40] --- [10,15] -- [5,10] --[0,5]
		int a = 15;
		int b = 40;
		for(;;){
			if(a==0){
				System.out.println(b);
				break;
			}
			int t = a;
			a = b%a;
			b = t;
		}
		
		int res = gcd(15,40);
		System.out.println(res);
		
	}
	
	//�����Լ��
	public static int gcd(int a, int b){
		if(a==0) return b;
		return gcd(b%a,a);
	}
}
