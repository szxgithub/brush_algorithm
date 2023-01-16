package 华为;

import java.util.Scanner;

//100%通过
/*
 * 给定一串字符，由单个空格隔开的若干个单词，请基于每个单词，将单词反序后重新输出整个字符串，
 * 比如 Yes sir, 经过反转后输出 seY ris
 * 
 */
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str = ReverseSentence(str);
		System.out.println(str);
	}
	public static String ReverseSentence(String str){
		if(str==null || !str.contains(" "))
			return str;
		String[] split = str.split(" ");
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<split.length;i++){
			split[i] = new StringBuilder(split[i]).reverse().toString();
		}
		
		for(int i=0;i<split.length;i++){
			if(i!=split.length-1){
				 sb.append(split[i]);
				 sb.append(" ");
			}else{
				sb.append(split[i]);
			}
		}
		return sb.toString();
	}
}
