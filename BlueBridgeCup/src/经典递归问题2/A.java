package 经典递归问题2;

//反转串
//我们把"cba" 称为 "abc"的反转串
//这是一道填空题
public class A {
	public static void main(String[] args) {
		System.out.println(reverseString("abcdef"));
	}
	
	public static String reverseString(String x){
		if(x==null || x.length()<2){
			return x;
		}
		return reverseString(x.substring(1))+x.charAt(0);
	}
}
