package 华为;

import java.util.HashMap;
import java.util.Scanner;

/*
 * 在一个给定的字符串中找到最后一个只出现一次的字符
 * 
 * 输入： 一个定长的字符串，其中字符没有顺序，字符可以重复
 * 
 * 输出：一个字符，如都大于1 ，输出null
 * 
 */
public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		HashMap<Character,Integer> hm = new HashMap<>();
		for(int i=0;i<str.length();i++){
			if(hm.containsKey(str.charAt(i))){
				int tmp = hm.get(str.charAt(i));
				hm.put(str.charAt(i), ++tmp);
			}else{
				hm.put(str.charAt(i), 1);
			}
		}
		
		Character c = null;
		for(int i=0;i<str.length();i++){
			if(hm.get(str.charAt(i))==1){
				c = str.charAt(i);
			}
		}
		System.out.println(c);
	}
}
