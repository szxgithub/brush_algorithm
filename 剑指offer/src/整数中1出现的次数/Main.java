package 整数中1出现的次数;

//求从1到n整数中1出现的次数
public class Main {
	public static void main(String[] args) {
		int res = NumberOfBetween1AndN_Solution(13);
		System.out.println(res);
	}
	public static int NumberOfBetween1AndN_Solution(int n){
		int count =0;
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++){
			sb.append(i);
		}
		for(int i=0;i<sb.length();i++){
			if(sb.charAt(i)=='1'){
				count++;
			}
		}
		return count;
	}
}
