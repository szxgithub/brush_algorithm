package 递归与循环;

public class A {
	
	//递归打印从0-n
	public static void f(int n){
		if(n>0)
			f(n-1);	//打印0-n-1
		System.out.println(n);	//打印n
	}
	
	//打印begin --- end
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
