package 第一个只出现一次的字符;

import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) {
		String str = "googgle";
		int res = FirstNotRepeatingChar(str);
		System.out.println(res);
	}
	
	/**
     * 使用整型数组对出现次数进行统计
     * 对应ASCII码表的256个字符
     * 数组的index就是字符, 值为字符出现的次数
     *
     * @param str
     * @return
     */
	public static int FirstNotRepeatingChar(String str){
		int[] cnts = new int[256];
		for(int i=0;i<str.length();i++){
			cnts[str.charAt(i)]++;
		}
		for(int i=0;i<str.length();i++){
			if(cnts[str.charAt(i)]==1){
				return i;
			}
		}
		return -1;
	}
}
