package 华为;

import java.util.Scanner;

public class Main12 {
	public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
	        while(in.hasNext()){
	            String str = in.nextLine();
	            char[] chs = str.toCharArray();
	            String result = null;
	            for(int i = 0; i < chs.length; i++){
	                if(str.indexOf(chs[i]) == str.lastIndexOf(chs[i])){
	                    result = chs[i] + "";
	                }
	            }
	            System.out.println(result);
	        }
	        in.close();
	}
}
