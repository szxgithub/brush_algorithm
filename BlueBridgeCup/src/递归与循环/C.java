package 递归与循环;

public class C {
	
	//比较两个字符串是否相等
	public static boolean isSameString(String s1, String s2){
		return s1.equals(s2);
	}
	
	public static boolean f(String s1, String s2){
		if(s1.length()!=s2.length())
			return false;
		if(s1.length()==0) return true;
		if(s1.charAt(0)!=s2.charAt(0))
			return false;
		return f(s1.substring(1),s2.substring(2));
	}  
	
	public static void main(String[] args) {
		
	}
}
