package 字符串的排列;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	public static ArrayList<String> lst = new ArrayList<>();
	
	public static void main(String[] args) {
		String str = "abc";
		ArrayList<String> ls = Permutation(str);
		System.out.println(ls.toString());
	}
	
	public static ArrayList<String> Permutation(String str){
		perm(str.toCharArray(), 0);
		return lst;
	}
	
	public static void perm(char[] chs, int m){
		int j; 
		char temp;
		if(m==chs.length-1){
			lst.add(Arrays.toString(chs));
			return;
		}
		
		//保持m元素之前的数据不变
		for(j=m;j<chs.length;j++){
			temp = chs[j];
			chs[j]= chs[m];
			chs[m] = temp;
			perm(chs, m+1);
			temp = chs[j];
			chs[j]= chs[m];
			chs[m] = temp;
		}
	}
}
