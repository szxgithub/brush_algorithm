package �ݹ���ѭ��;

public class A {
	
	//�ݹ��ӡ��0-n
	public static void f(int n){
		if(n>0)
			f(n-1);	//��ӡ0-n-1
		System.out.println(n);	//��ӡn
	}
	
	//��ӡbegin --- end
	public static void f2(int begin, int end){
		if(begin>end) return;
		System.out.println(begin);
		f2(begin+1,end);
	}
	
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			System.out.println(i);
		}
	}
}
