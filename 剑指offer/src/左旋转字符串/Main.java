package 左旋转字符串;

public class Main {
	public static void main(String[] args) {
		String res = LeftRotateString("abcXYZdef", 3);
		System.out.println(res);
	}
	
	public static String LeftRotateString(String str, int n){
		if(str.length()==0)
			return str;
		String tmp = str;
		String s1 = tmp.substring(n);
		String s2 = str.substring(0, n);
		return s1+s2;
	}
}
