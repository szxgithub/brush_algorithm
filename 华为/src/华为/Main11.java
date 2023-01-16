package 华为;

import java.util.Scanner;

public class Main11 {
	public static Character res = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		System.out.println(onceChar(str));
	}
	
	public static char onceChar(String str){
        if(str == null)
            return res;
        int[] freq = new int[257];
        for (int i = 0; i < str.length(); i++)
            freq[str.charAt(i)]++;
        for(int i = 0; i < str.length(); i++){
            if(freq[str.charAt(i)] == 1){            	
            	 res = str.charAt(i);
            }
        }
        return res;
    }
	
}
