package 二进制中1的个数;

public class Main {
	/*public int NumberOf1(int n) {
	
    }*/
	
	public static void main(String[] args) {
		String res = Integer.toBinaryString(-3);
		System.out.println(res);
	}
	
	public int NumberOf1(int n) {
		String res = Integer.toBinaryString(n);
		int count =0;
		for(int i=0;i<res.length();i++){
			if(res.charAt(i)=='1'){
				count++;
			}
		}
		return count;
    }
}
